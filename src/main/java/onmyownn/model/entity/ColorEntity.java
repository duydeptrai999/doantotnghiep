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

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "color_tbl")
public class ColorEntity {

    public static final int STATUS_USE = 1;
    public static final int STATUS_NOT_USE = 0;

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
    @Column(nullable = false)
    private Integer status = STATUS_USE;

    @JsonIgnore
    @OneToMany(mappedBy = "color", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProductDetailEntity> productDetails = new ArrayList<>();
}