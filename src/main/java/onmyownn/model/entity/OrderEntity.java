package onmyownn.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "order_tbl")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @NotBlank(message = "Tên khách hàng không được để trống")
    @Column(nullable = false)
    private String name;

    @NotBlank(message = "Số điện thoại không được để trống")
    @Column(nullable = false)
    private String phone;

    @Column
    private String email;

    @Column
    private String address;

    @Column
    private String note;

    @Column
    private String code;

    @Column(name = "confirmed_at")
    private LocalDateTime confirmedAt;

    @NotNull(message = "Trạng thái không được để trống")
    @Column(nullable = false)
    private Integer status;

    @NotNull(message = "Trạng thái thanh toán không được để trống")
    @Column(nullable = false)
    private Boolean paymentStatus;

    @NotNull(message = "Loại thanh toán không được để trống")
    @Column(nullable = false)
    private Integer paymentType;

    @NotNull(message = "Tổng tiền thanh toán không được để trống")
    @Column(nullable = false)
    private Integer totalPayment;

    @NotNull(message = "Tổng giá trị đơn hàng không được để trống")
    @Column(nullable = false)
    private Double totalPrice;

    @NotNull(message = "Tổng giá trị giảm không được để trống")
    @Column(nullable = false)
    private Double totalDiscount;

    // Quan hệ với AccountEntity (customer)
    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private AccountEntity customer;

    // Quan hệ với AccountEntity (employee)
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private AccountEntity employee;

    // Quan hệ với VoucherEntity
    @ManyToOne
    @JoinColumn(name = "voucher_id")
    private VoucherEntity voucher;
}
