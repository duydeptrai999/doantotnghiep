package onmyownn.controller;

import lombok.RequiredArgsConstructor;
import onmyownn.model.entity.BrandEntity;
import onmyownn.model.entity.CategoryEntity;
import onmyownn.model.entity.MaterialEntity;
import onmyownn.model.entity.ProductEntity;
import onmyownn.model.entity.ProductDetailEntity;
import onmyownn.service.BrandService;
import onmyownn.service.CategoryService;
import onmyownn.service.MaterialService;
import onmyownn.service.ProductDetailService;
import onmyownn.service.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;
    private final CategoryService categoryService;
    private final BrandService brandService;
    private final MaterialService materialService;
    private final ProductDetailService productDetailService;

    @GetMapping("/list")
    public String listProducts(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "12") int size,
            Model model) {
        
        // Lấy danh sách sản phẩm có phân trang
        Pageable pageable = PageRequest.of(page, size);
        Page<ProductEntity> productPage = productService.findAll(pageable);
        List<ProductEntity> products = new ArrayList<>(productPage.getContent());
        
        // Lấy chi tiết sản phẩm cho mỗi sản phẩm
        for (ProductEntity product : products) {
            List<ProductDetailEntity> details = productDetailService.findByProductId(product.getId());
            product.setProductDetails(details);
        }
        
        // Thêm dữ liệu vào model
        model.addAttribute("products", products);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", productPage.getTotalPages());
        model.addAttribute("totalItems", productPage.getTotalElements());
        
        return "product/list";
    }

    @RequestMapping("/active")
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

    @RequestMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("product", new ProductEntity());
        loadFormDependencies(model);
        return "product/add";
    }

    @RequestMapping("/save")
    public String addProduct(@Valid @ModelAttribute("product") ProductEntity product,
                           BindingResult result, Model model) {
        if (result.hasErrors()) {
            loadFormDependencies(model);
            return "product/add";
        }
        productService.save(product);
        return "redirect:/product/list";
    }

    @RequestMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        ProductEntity product = productService.findById(id);
        if (product == null) {
            return "redirect:/product/list";
        }
        model.addAttribute("product", product);
        loadFormDependencies(model);
        return "product/edit";
    }

    @RequestMapping("/update/{id}")
    public String updateProduct(@PathVariable Long id,
                              @Valid @ModelAttribute("product") ProductEntity product,
                              BindingResult result, Model model) {
        if (result.hasErrors()) {
            loadFormDependencies(model);
            return "product/edit";
        }
        product.setId(id);
        productService.save(product);
        return "redirect:/product/list";
    }

    @RequestMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productService.deleteById(id);
        return "redirect:/product/list";
    }

    private void loadFormDependencies(Model model) {
        List<CategoryEntity> categories = categoryService.findAllActive();
        List<BrandEntity> brands = brandService.findAllActive();
        List<MaterialEntity> materials = materialService.findAllActive();

        model.addAttribute("categories", categories);
        model.addAttribute("brands", brands);
        model.addAttribute("materials", materials);
    }
}
