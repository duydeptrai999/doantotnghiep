package onmyownn.model.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "image_tbl")
public class ImageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @NotBlank
    @Column(name = "source", nullable = false)
    private String source;

    @Transient
    public String getUrl() {
        return this.source;
    }

    @ManyToOne
    @JoinColumn(name = "product_detail_id", nullable = false)
    private ProductDetailEntity productDetail;
}
