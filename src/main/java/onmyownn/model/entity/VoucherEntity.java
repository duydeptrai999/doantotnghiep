package onmyownn.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "voucher_tbl")
public class VoucherEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(nullable = false)
  private Long id;

  @NotBlank(message = "Tên mã giảm giá không được để trống")
  @Column(nullable = false, unique = true)
  private String name;

  @NotBlank(message = "Mã giảm giá không được để trống")
  @Column(nullable = false, unique = true)
  private String code;

  @NotNull(message = "Loại voucher không được để trống")
  @Column(nullable = false)
  private Boolean type; // true = phần trăm, false = số tiền cụ thể

  @NotNull(message = "Thời gian bắt đầu không được để trống")
  @Column(nullable = false)
  private LocalDateTime startAt;

  @NotNull(message = "Thời gian kết thúc không được để trống")
  @Column(nullable = false)
  private LocalDateTime endAt;

  @NotNull(message = "Giá trị giảm không được để trống")
  @Column(nullable = false)
  private Double price;

  @NotNull(message = "Giá trị giảm tối đa không được để trống")
  @Column(nullable = false)
  private Double maxPrice;

  @NotNull(message = "Số tiền tối thiểu để áp dụng không được để trống")
  @Column(nullable = false)
  private Double minimumPrice;

  @NotNull(message = "Số lượng voucher không được để trống")
  @Column(nullable = false)
  private Integer quantity;

  @NotNull(message = "Giá trị đơn hàng tối thiểu không được để trống")
  @Column(nullable = false)
  private Double minOrderValue;
}
