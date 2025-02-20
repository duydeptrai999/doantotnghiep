package onmyownn.controller;

import onmyownn.model.entity.ProductDetailEntity;
import onmyownn.service.ProductDetailService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/product-details")
public class ProductDetailController {

    private final ProductDetailService productDetailService;

    public ProductDetailController(ProductDetailService productDetailService) {
        this.productDetailService = productDetailService;
    }

    // ✅ Hiển thị danh sách sản phẩm chi tiết (có phân trang)
    @GetMapping
    public String getAllProductDetailsPaged(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            Model model) {
        Pageable pageable = PageRequest.of(page, size);
        Page<ProductDetailEntity> productDetails = productDetailService.findAll(pageable);
        model.addAttribute("productDetails", productDetails);
        return "product-details/productDetailList"; // Trả về đúng đường dẫn JSP
    }

    // ✅ Hiển thị chi tiết sản phẩm
    @GetMapping("/{id}")
    public String getProductDetailById(@PathVariable Long id, Model model) {
        Optional<ProductDetailEntity> productDetail = Optional.ofNullable(productDetailService.findById(id));
        if (!productDetail.isPresent()) {
            return "redirect:/product-details?error=not_found"; // Chuyển hướng nếu không tìm thấy
        }
        model.addAttribute("productDetail", productDetail.get());
        return "product-details/productDetail"; // Trả về đúng JSP
    }

    // ✅ Hiển thị form chỉnh sửa sản phẩm
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Optional<ProductDetailEntity> productDetail = Optional.ofNullable(productDetailService.findById(id));
        if (!productDetail.isPresent()) {
            return "redirect:/product-details?error=not_found"; // Nếu không tìm thấy, quay lại danh sách
        }
        model.addAttribute("productDetail", productDetail.get());
        return "product-details/productDetailForm"; // Hiển thị form chỉnh sửa
    }

    // ✅ Cập nhật sản phẩm chi tiết
    @PostMapping("/save")
    public String saveProductDetail(@ModelAttribute ProductDetailEntity productDetail) {
        productDetailService.update(productDetail);
        return "redirect:/product-details?success=updated"; // Chuyển hướng sau khi cập nhật thành công
    }

    // ✅ Xóa mềm sản phẩm chi tiết
    @GetMapping("/delete/{id}")
    public String softDeleteProductDetail(@PathVariable Long id) {
        productDetailService.changeStatus(id, 0); // 0 là trạng thái không hoạt động
        return "redirect:/product-details?success=deleted";
    }

    // ✅ Kích hoạt lại sản phẩm chi tiết
    @GetMapping("/activate/{id}")
    public String activateProductDetail(@PathVariable Long id) {
        productDetailService.changeStatus(id, 1); // 1 là trạng thái hoạt động
        return "redirect:/product-details?success=activated";
    }
}
