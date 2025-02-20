package onmyownn.controller;

import onmyownn.model.entity.CartEntity;
import onmyownn.model.entity.CartDetailEntity;
import onmyownn.service.CartService;
import onmyownn.service.CartDetailService;
import onmyownn.service.ProductDetailService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/cart")
public class CartController {

    private final CartService cartService;
    private final CartDetailService cartDetailService;
    private final ProductDetailService productDetailService;

    public CartController(CartService cartService, CartDetailService cartDetailService, ProductDetailService productDetailService) {
        this.cartService = cartService;
        this.cartDetailService = cartDetailService;
        this.productDetailService = productDetailService;
    }

    // 🛒 **Lấy giỏ hàng của user và hiển thị lên JSP**
    @GetMapping("/{accountId}")
    public String getCart(@PathVariable Long accountId, Model model) {
        CartEntity cart = cartService.findByAccountId(accountId);
        List<CartDetailEntity> cartDetails = cartDetailService.findByCartId(cart.getId());
        model.addAttribute("cart", cart);
        model.addAttribute("cartDetails", cartDetails);
        return "cart/view";  // Chuyển hướng đến trang `cart/view.jsp`
    }

    // ➕ **Thêm sản phẩm vào giỏ hàng**
    @PostMapping("/add")
    public String addToCart(@RequestParam Long productDetailId, @RequestParam int quantity, @RequestParam Long accountId) {
        CartEntity cart = cartService.findByAccountId(accountId);
        CartDetailEntity cartDetail = new CartDetailEntity();
        cartDetail.setCart(cart);
        cartDetail.setProductDetail(productDetailService.findById(productDetailId));
        cartDetail.setQuantity(quantity);
        cartDetail.setStatus(1);
        cartDetailService.save(cartDetail);
        return "redirect:/cart/" + accountId;
    }

    // 🗑 **Xóa sản phẩm khỏi giỏ hàng**
    @GetMapping("/remove/{cartDetailId}/{accountId}")
    public String removeFromCart(@PathVariable Long cartDetailId, @PathVariable Long accountId) {
        cartDetailService.deleteById(cartDetailId);
        return "redirect:/cart/" + accountId;
    }

    // 🧹 **Xóa toàn bộ giỏ hàng**
    @GetMapping("/clear/{cartId}/{accountId}")
    public String clearCart(@PathVariable Long cartId, @PathVariable Long accountId) {
        cartDetailService.deleteByCartId(cartId);
        return "redirect:/cart/" + accountId;
    }
}
