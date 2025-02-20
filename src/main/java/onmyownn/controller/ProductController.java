package onmyownn.controller;

import onmyownn.model.entity.BrandEntity;
import onmyownn.model.entity.CategoryEntity;
import onmyownn.model.entity.MaterialEntity;
import onmyownn.model.entity.ProductEntity;
import onmyownn.service.BrandService;
import onmyownn.service.CategoryService;
import onmyownn.service.MaterialService;
import onmyownn.service.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;
    private final CategoryService categoryService;
    private final BrandService brandService;
    private final MaterialService materialService;

    public ProductController(ProductService productService,
                             CategoryService categoryService,
                             BrandService brandService,
                             MaterialService materialService) {
        this.productService = productService;
        this.categoryService = categoryService;
        this.brandService = brandService;
        this.materialService = materialService;
    }

    // Hiển thị danh sách sản phẩm (có phân trang)
    @GetMapping
    public String getAllProductsPaged(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            Model model) {
        Pageable pageable = PageRequest.of(page, size);
        Page<ProductEntity> products = productService.findAll(pageable);
        model.addAttribute("products", products);
        return "product/list";  // Đổi từ productList.jsp → list.jsp
    }

    // Hiển thị danh sách sản phẩm đang bán
    @GetMapping("/active")
    public String getActiveProductsPaged(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            Model model) {
        Pageable pageable = PageRequest.of(page, size);
        Page<ProductEntity> products = productService.findActiveProducts(pageable);
        model.addAttribute("products", products);
        model.addAttribute("activeOnly", true);
        return "product/list";
    }

    // Xem chi tiết sản phẩm
    @GetMapping("/{id}")
    public String getProductById(@PathVariable Long id, Model model) {
        ProductEntity product = productService.findById(id);
        if (product == null) {
            return "redirect:/products";
        }
        model.addAttribute("product", product);
        return "product/detail";
    }

    // Hiển thị form thêm mới sản phẩm
    @GetMapping("/new")
    public String showCreateForm(Model model) {
        ProductEntity product = new ProductEntity();
        model.addAttribute("product", product);
        loadFormDependencies(model);
        model.addAttribute("formTitle", "Thêm sản phẩm mới");
        model.addAttribute("formAction", "/products/save");
        return "product/form";
    }

    // Hiển thị form chỉnh sửa sản phẩm
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        ProductEntity product = productService.findById(id);
        if (product == null) {
            return "redirect:/products";
        }
        model.addAttribute("product", product);
        loadFormDependencies(model);
        model.addAttribute("formTitle", "Chỉnh sửa sản phẩm");
        model.addAttribute("formAction", "/products/save");
        return "product/form";  // Đổi từ productForm.jsp → form.jsp
    }

    // Lưu sản phẩm (thêm mới hoặc cập nhật)
    @PostMapping("/save")
    public String saveProduct(@Valid @ModelAttribute ProductEntity product,
                              BindingResult bindingResult,
                              Model model) {
        if (bindingResult.hasErrors()) {
            loadFormDependencies(model);
            model.addAttribute("formTitle", product.getId() == null ? "Thêm sản phẩm mới" : "Chỉnh sửa sản phẩm");
            model.addAttribute("formAction", "/products/save");
            return "product/form";  // Đổi từ productForm.jsp → form.jsp
        }

        productService.save(product);
        return "redirect:/products";
    }

    // Xác nhận xóa sản phẩm (chuyển sang trang xác nhận)
    @GetMapping("/delete/{id}/confirm")
    public String confirmDelete(@PathVariable Long id, Model model) {
        ProductEntity product = productService.findById(id);
        if (product == null) {
            return "redirect:/products";
        }
        model.addAttribute("product", product);
        return "product/confirmDelete";  // Đổi từ confirmDelete.jsp → confirmDelete.jsp (giữ nguyên)
    }

    // Xóa mềm sản phẩm (đổi status)
    @GetMapping("/delete/{id}")
    public String changeProductStatus(@PathVariable Long id) {
        productService.changeStatus(id, ProductEntity.STATUS_NOT_USE);
        return "redirect:/products";
    }

    // Kích hoạt lại sản phẩm
    @GetMapping("/activate/{id}")
    public String activateProduct(@PathVariable Long id) {
        productService.changeStatus(id, ProductEntity.STATUS_USE);
        return "redirect:/products";
    }

    // Helper method để tải danh sách danh mục, thương hiệu, chất liệu cho form
    private void loadFormDependencies(Model model) {
        List<CategoryEntity> categories = categoryService.findAllActive();
        List<BrandEntity> brands = brandService.findAllActive();
        List<MaterialEntity> materials = materialService.findAllActive();

        model.addAttribute("categories", categories);
        model.addAttribute("brands", brands);
        model.addAttribute("materials", materials);
    }
}
