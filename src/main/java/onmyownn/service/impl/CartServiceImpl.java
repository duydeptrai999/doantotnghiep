package onmyownn.service.impl;

import lombok.RequiredArgsConstructor;
import onmyownn.model.entity.*;
import onmyownn.repository.CartRepository;
import onmyownn.repository.CartDetailRepository;
import onmyownn.repository.ProductDetailRepository;
import onmyownn.service.CartService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {
    private final CartRepository cartRepository;
    private final CartDetailRepository cartDetailRepository;
    private final ProductDetailRepository productDetailRepository;

    @Override
    public CartEntity getCartByAccount(AccountEntity account) {
        return cartRepository.findByAccount(account)
            .orElseGet(() -> {
                CartEntity newCart = new CartEntity();
                newCart.setAccount(account);
                return cartRepository.save(newCart);
            });
    }

    @Override
    public CartEntity addToCart(AccountEntity account, Long productDetailId, Integer quantity) {
        if (quantity <= 0) {
            throw new RuntimeException("Số lượng sản phẩm phải lớn hơn 0");
        }

        CartEntity cart = getCartByAccount(account);
        ProductDetailEntity productDetail = productDetailRepository.findById(productDetailId)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy sản phẩm"));

        CartDetailEntity cartDetail = cart.getCartDetails().stream()
                .filter(detail -> detail.getProductDetail().getId().equals(productDetailId))
                .findFirst()
                .orElse(null);

        if (cartDetail == null) {
            cartDetail = new CartDetailEntity();
            cartDetail.setCart(cart);
            cartDetail.setProductDetail(productDetail);
            cartDetail.setQuantity(quantity);
            cartDetail.setStatus(1);
            cart.getCartDetails().add(cartDetail);
        } else {
            cartDetail.setQuantity(cartDetail.getQuantity() + quantity);
        }

        return cartRepository.save(cart);
    }

    @Override
    public CartEntity updateCartItemQuantity(AccountEntity account, Long cartDetailId, Integer quantity) {
        if (quantity <= 0) {
            throw new RuntimeException("Số lượng sản phẩm phải lớn hơn 0");
        }

        CartEntity cart = getCartByAccount(account);
        CartDetailEntity cartDetail = cartDetailRepository.findById(cartDetailId)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy sản phẩm trong giỏ hàng"));

        if (!cart.equals(cartDetail.getCart())) {
            throw new RuntimeException("Sản phẩm không thuộc giỏ hàng của bạn");
        }

        cartDetail.setQuantity(quantity);
        cartDetailRepository.save(cartDetail);
        
        return cartRepository.findById(cartDetail.getCart().getId())
                .orElseThrow(() -> new RuntimeException("Không tìm thấy giỏ hàng"));
    }

    @Override
    public void removeCartItem(AccountEntity account, Long cartDetailId) {
        CartEntity cart = getCartByAccount(account);
        CartDetailEntity cartDetail = cartDetailRepository.findById(cartDetailId)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy sản phẩm trong giỏ hàng"));
                
        if (!cart.equals(cartDetail.getCart())) {
            throw new RuntimeException("Sản phẩm không thuộc giỏ hàng của bạn");
        }
                
        cartDetailRepository.deleteById(cartDetailId);
        cart.getCartDetails().remove(cartDetail);
        cartRepository.save(cart);
    }

    @Override
    public CartEntity getCart(Long accountId) {
        return cartRepository.findByAccountId(accountId)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy giỏ hàng"));
    }

    @Override
    public void clearCart(Long cartId) {
        CartEntity cart = cartRepository.findById(cartId)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy giỏ hàng"));
                
        cartDetailRepository.deleteByCartId(cartId);
        cart.getCartDetails().clear();
        cartRepository.save(cart);
    }
}
