package onmyownn.model.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "order_detail_tbl")
public class OrderDetailEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @NotNull(message = "Giá sản phẩm không được để trống")
    @Column(nullable = false)
    private Double price;

    @NotNull(message = "Số lượng không được để trống")
    @Column(nullable = false)
    private Integer quantity;

    @Column
    private Integer status;

    @NotNull(message = "Mã đơn hàng không được để trống")
    @Column(nullable = false, unique = true)
    private String code;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private OrderEntity order;

    @ManyToOne
    @JoinColumn(name = "product_detail_id", nullable = false)
    private ProductDetailEntity productDetail;
}
