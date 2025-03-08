package onmyownn.service;

import onmyownn.model.entity.AccountEntity;
import onmyownn.model.entity.CartEntity;
import onmyownn.model.entity.CartDetailEntity;
import onmyownn.model.entity.ProductDetailEntity;
import onmyownn.repository.CartRepository;
import onmyownn.repository.CartDetailRepository;
import onmyownn.repository.ProductDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

public interface CartService {
    CartEntity getCartByAccount(AccountEntity account);
    CartEntity addToCart(AccountEntity account, Long productDetailId, Integer quantity);
    CartEntity updateCartItemQuantity(AccountEntity account, Long cartDetailId, Integer quantity);
    void removeCartItem(AccountEntity account, Long cartDetailId);
    CartEntity getCart(Long accountId);
    void clearCart(Long cartId);
}
