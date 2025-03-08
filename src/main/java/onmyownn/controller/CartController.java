package onmyownn.controller;

import lombok.RequiredArgsConstructor;
import onmyownn.model.entity.AccountEntity;
import onmyownn.model.entity.CartEntity;
import onmyownn.model.entity.ProductDetailEntity;
import onmyownn.repository.AccountRepository;
import onmyownn.service.CartService;
import onmyownn.service.ProductDetailService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/cart")
@RequiredArgsConstructor
public class CartController {
    private final CartService cartService;
    private final AccountRepository accountRepository;
    private final ProductDetailService productDetailService;

    @GetMapping
    public String viewCart(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        
        AccountEntity account = accountRepository.findByUsername(username)
            .orElseThrow(() -> new RuntimeException("Không tìm thấy tài khoản"));
            
        CartEntity cart = cartService.getCartByAccount(account);
        int cartCount = cart.getCartDetails().size();
        
        model.addAttribute("cart", cart);
        model.addAttribute("cartCount", cartCount);
        
        return "cart/view";
    }

    @PostMapping("/add")
    public String addToCart(@RequestParam Long colorId,
                          @RequestParam Long sizeId,
                          @RequestParam Integer quantity,
                          @RequestParam Long productId,
                          RedirectAttributes redirectAttributes) {
        try {
            AccountEntity account = accountRepository.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName())
                    .orElseThrow(() -> new RuntimeException("Không tìm thấy tài khoản"));

            // Tìm productDetailId từ colorId và sizeId
            ProductDetailEntity productDetail = productDetailService.findByProductAndColorAndSize(productId, colorId, sizeId)
                    .orElseThrow(() -> new RuntimeException("Không tìm thấy sản phẩm với màu sắc và kích thước đã chọn"));

            cartService.addToCart(account, productDetail.getId(), quantity);
            redirectAttributes.addFlashAttribute("successMessage", "Đã thêm sản phẩm vào giỏ hàng thành công!");
            return "redirect:/product/detail/" + productId;
        } catch (RuntimeException e) {
            redirectAttributes.addFlashAttribute("errorMessage", e.getMessage());
            return "redirect:/product/detail/" + productId;
        }
    }

    @GetMapping("/update")
    public String updateQuantity(@RequestParam Long itemId, 
                               @RequestParam int quantity,
                               RedirectAttributes redirectAttributes) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        
        AccountEntity account = accountRepository.findByUsername(username)
            .orElseThrow(() -> new RuntimeException("Không tìm thấy tài khoản"));
            
        cartService.updateCartItemQuantity(account, itemId, quantity);
        redirectAttributes.addFlashAttribute("successMessage", "Đã cập nhật số lượng sản phẩm!");
        
        return "redirect:/cart";
    }

    @GetMapping("/remove")
    public String removeItem(@RequestParam Long itemId,
                           RedirectAttributes redirectAttributes) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        
        AccountEntity account = accountRepository.findByUsername(username)
            .orElseThrow(() -> new RuntimeException("Không tìm thấy tài khoản"));
            
        cartService.removeCartItem(account, itemId);
        redirectAttributes.addFlashAttribute("successMessage", "Đã xóa sản phẩm khỏi giỏ hàng!");
        
        return "redirect:/cart";
    }
}
