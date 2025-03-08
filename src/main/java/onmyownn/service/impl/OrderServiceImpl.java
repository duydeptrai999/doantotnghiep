package onmyownn.service.impl;

import lombok.RequiredArgsConstructor;
import onmyownn.model.entity.*;
import onmyownn.repository.OrderRepository;
import onmyownn.service.CartService;
import onmyownn.service.OrderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final CartService cartService;

    @Override
    @Transactional
    public OrderEntity createOrder(AccountEntity account, CartEntity cart, String name, 
                                 String phone, String email, String address, String note, 
                                 Integer paymentType, VoucherEntity voucher) {
        OrderEntity order = new OrderEntity();
        order.setCustomer(account);
        order.setName(name);
        order.setPhone(phone);
        order.setEmail(email);
        order.setAddress(address);
        order.setNote(note);
        order.setCode("DH" + System.currentTimeMillis()); // Tạo mã đơn hàng
        order.setStatus(0); // Chờ xác nhận
        order.setPaymentType(paymentType);
        order.setPaymentStatus(false);
        
        // Tính tổng tiền và giảm giá
        double totalPrice = cart.getCartDetails().stream()
                .mapToDouble(item -> item.getProductDetail().getPrice() * item.getQuantity())
                .sum();
        order.setTotalPrice(totalPrice);
        
        double totalDiscount = 0;
        if (voucher != null) {
            if (voucher.getType()) { // Giảm theo %
                totalDiscount = totalPrice * voucher.getPrice() / 100;
                if (totalDiscount > voucher.getMaxPrice()) {
                    totalDiscount = voucher.getMaxPrice();
                }
            } else { // Giảm theo số tiền
                totalDiscount = voucher.getPrice();
            }
            order.setVoucher(voucher);
        }
        order.setTotalDiscount(totalDiscount);
        order.setTotalPayment((int)(totalPrice - totalDiscount));
        
        // Chuyển cart items thành order items
        cart.getCartDetails().forEach(cartItem -> {
            OrderDetailEntity orderDetail = new OrderDetailEntity();
            orderDetail.setOrder(order);
            orderDetail.setProductDetail(cartItem.getProductDetail());
            orderDetail.setQuantity(cartItem.getQuantity());
            orderDetail.setPrice(cartItem.getProductDetail().getPrice());
            orderDetail.setStatus(1);
            orderDetail.setCode("DHCT" + System.currentTimeMillis());
            order.getOrderDetails().add(orderDetail);
        });

        return orderRepository.save(order);
    }

    @Override
    public OrderEntity findByPaymentTransactionNo(String transactionNo) {
        return orderRepository.findByPaymentTransactionNo(transactionNo)
                .orElse(null);
    }

    @Override
    public OrderEntity getOrder(Long orderId) {
        return orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy đơn hàng"));
    }

    @Override
    @Transactional
    public OrderEntity save(OrderEntity order) {
        return orderRepository.save(order);
    }

    @Override
    public List<OrderEntity> getUserOrders(Long userId) {
        return orderRepository.findByCustomerIdOrderByIdDesc(userId);
    }

    @Override
    public void deleteById(Long id) {
        orderRepository.deleteById(id);
    }

    @Override
    public List<OrderEntity> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public void updatePaymentStatus(Long orderId, boolean status, String transactionNo) {
        OrderEntity order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy đơn hàng"));
        
        order.setPaymentStatus(status);
        order.setPaymentTransactionNo(transactionNo);
        
        if (status) {
            order.setStatus(1); // Đã thanh toán
            // Chỉ xóa giỏ hàng khi thanh toán thành công
            CartEntity cart = cartService.getCartByAccount(order.getCustomer());
            cartService.clearCart(cart.getId());
        }
        
        orderRepository.save(order);
    }

    @Override
    public OrderEntity findByCode(String code) {
        return orderRepository.findByCode(code)
                .orElse(null);
    }
}
