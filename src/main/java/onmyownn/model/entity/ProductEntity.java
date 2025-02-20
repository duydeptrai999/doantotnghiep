package onmyownn.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import onmyownn.support.enums.StatusEnum;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "product_tbl")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @ToString.Include
    @NotBlank
    @Column(nullable = false, unique = true)
    private String name;

    @Column
    private String description;

    @ToString.Include
    @Column(nullable = false, unique = true, length = 100)
    private String code;

    @ToString.Include
    @Column(nullable = false)
    private Integer status = StatusEnum.USE.getValue();

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private CategoryEntity category;

    @ManyToOne
    @JoinColumn(name = "material_id", nullable = false)
    private MaterialEntity material;

    @ManyToOne
    @JoinColumn(name = "brand_id", nullable = false)
    private BrandEntity brand;

    @JsonIgnore
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProductDetailEntity> productDetails = new ArrayList<>();
}
