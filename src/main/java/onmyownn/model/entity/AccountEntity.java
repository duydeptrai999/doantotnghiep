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

import onmyownn.support.enums.RoleEnum;
import onmyownn.support.enums.StatusEnum;

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

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RoleEnum role;

    @Column(nullable = false)
    private Integer status = StatusEnum.USE.getValue();

    // Khách hàng có thể có nhiều đơn hàng
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderEntity> customerOrders = new ArrayList<>();

    // Nhân viên có thể có nhiều đơn hàng
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderEntity> employeeOrders = new ArrayList<>();

    // Một tài khoản có thể có nhiều giỏ hàng
    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CartEntity> carts = new ArrayList<>();
}
