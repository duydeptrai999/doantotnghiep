package onmyownn.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "account_tbl")
public class AccountEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @NotBlank
    @Email
    @Column(nullable = false, unique = true)
    private String email;

    @NotBlank
    @Column(nullable = false)
    private String name;

    @NotBlank
    @Column(nullable = false, unique = true)
    private String username;

    @JsonIgnore
    @NotBlank
    @Column(nullable = false)
    private String password;

    @Column(unique = true)
    private String phone;

    @Column
    private String address;

    @Column(nullable = false)
    private String role; // "ADMIN", "EMPLOYEE", "CUSTOMER" thay vì RoleEnum

    @Column(nullable = false)
    private Integer status = 1; // 1: Hoạt động, 0: Không hoạt động

    // Khách hàng có thể có nhiều đơn hàng
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderEntity> customerOrders = new ArrayList<>();

    // Nhân viên có thể có nhiều đơn hàng
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderEntity> employeeOrders = new ArrayList<>();

    // Một tài khoản có thể có nhiều giỏ hàng
    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CartEntity> carts = new ArrayList<>();

    // Constants for role values
    public static final String ROLE_ADMIN = "ADMIN";
    public static final String ROLE_EMPLOYEE = "EMPLOYEE";
    public static final String ROLE_CUSTOMER = "CUSTOMER";

    // Constants for status values
    public static final Integer STATUS_ACTIVE = 1;
    public static final Integer STATUS_INACTIVE = 0;
}