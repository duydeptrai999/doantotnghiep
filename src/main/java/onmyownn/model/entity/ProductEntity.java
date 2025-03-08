package onmyownn.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
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
@Table(name = "product_tbl")
public class ProductEntity {

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
    @Column(nullable = false, unique = true, length = 100)
    private String code;

    @ToString.Include
    @Column(nullable = false)
    private Integer status = STATUS_USE;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private CategoryEntity category;

    @ManyToOne
    @JoinColumn(name = "material_id", nullable = false)
    private MaterialEntity material;

    @ManyToOne
    @JoinColumn(name = "brand_id", nullable = false)
    private BrandEntity brand;

    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    private List<ProductDetailEntity> productDetails = new ArrayList<>();

    @Transient
    public List<SizeEntity> getSizes() {
        return productDetails.stream()
                .map(ProductDetailEntity::getSize)
                .distinct()
                .collect(Collectors.toList());
    }

    @Transient
    public List<ColorEntity> getColors() {
        return productDetails.stream()
                .map(ProductDetailEntity::getColor)
                .distinct()
                .collect(Collectors.toList());
    }

    @Transient
    public Double getPrice() {
        if (productDetails == null || productDetails.isEmpty()) {
            return 0.0;
        }
        return productDetails.stream()
                .map(ProductDetailEntity::getPrice)
                .min(Double::compareTo)
                .orElse(0.0);
    }

    @Transient
    public List<ImageEntity> getImages() {
        List<ImageEntity> images = new ArrayList<>();
        for (ProductDetailEntity detail : productDetails) {
            images.addAll(detail.getImages());
        }
        return images;
    }

    @Transient
    public List<String> getAllImages() {
        List<ImageEntity> images = getImages();
        List<String> imageUrls = new ArrayList<>();
        
        if (images != null && !images.isEmpty()) {
            for (ImageEntity image : images) {
                String source = image.getSource();
                if (source != null && !source.trim().isEmpty()) {
                    // Xử lý URL Google Drive
                    if (source.contains("drive.google.com/file/d/")) {
                        String fileId = source.split("/d/")[1].split("/")[0];
                        imageUrls.add("https://lh3.googleusercontent.com/d/" + fileId);
                    }
                    // Xử lý URL Google Drive dạng chia sẻ
                    else if (source.contains("drive.google.com/open?id=")) {
                        String fileId = source.split("id=")[1];
                        imageUrls.add("https://lh3.googleusercontent.com/d/" + fileId);
                    }
                    // Xử lý URL Bing hoặc các URL khác
                    else {
                        imageUrls.add(source);
                    }
                }
            }
        }
        
        // Nếu không có ảnh nào, sử dụng ảnh mặc định
        if (imageUrls.isEmpty()) {
            imageUrls.add("https://placehold.co/400x400?text=No+Image");
        }
        
        return imageUrls;
    }

    @Transient
    public String getThumbnail() {
        List<String> images = getAllImages();
        return images.get(0);
    }
}