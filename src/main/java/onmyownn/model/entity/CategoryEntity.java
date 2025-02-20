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
@Table(name = "category_tbl")
public class CategoryEntity {

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
    private Integer status = StatusEnum.USE.getValue();

    @JsonIgnore
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProductEntity> products = new ArrayList<>();
}
