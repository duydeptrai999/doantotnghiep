package onmyownn.service;

import onmyownn.model.entity.*;
import java.util.List;

public interface OrderService {
    OrderEntity createOrder(AccountEntity account, CartEntity cart, String name, 
                          String phone, String email, String address, String note, 
                          Integer paymentType, VoucherEntity voucher);
    
    OrderEntity findByPaymentTransactionNo(String transactionNo);
    
    OrderEntity getOrder(Long orderId);
    
    OrderEntity findByCode(String code);
    
    OrderEntity save(OrderEntity order);
    
    List<OrderEntity> getUserOrders(Long userId);
    
    void deleteById(Long id);
    
    List<OrderEntity> findAll();
    
    void updatePaymentStatus(Long orderId, boolean status, String transactionNo);
}
