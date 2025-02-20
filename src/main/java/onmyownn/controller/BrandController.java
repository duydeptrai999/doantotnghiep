package onmyownn.controller;

import onmyownn.model.entity.BrandEntity;
import onmyownn.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("/brand")
public class BrandController {

    @Autowired
    private BrandService brandService;

    @GetMapping("/list")
    public String listBrands(@RequestParam(name = "page", defaultValue = "0") Integer page, Model model) {
        Pageable pageable = PageRequest.of(page, 5);
        Page<BrandEntity> brands = brandService.findAll(pageable);
        model.addAttribute("brands", brands);
        return "brand/list";  // Trả về trang danh sách thương hiệu
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("brand", new BrandEntity());
        model.addAttribute("statusList", getStatusList());
        return "brand/add";  // Trả về trang thêm thương hiệu
    }

    @PostMapping("/add")
    public String addBrand(@Valid @ModelAttribute("brand") BrandEntity brand, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("statusList", getStatusList());
            return "brand/add";
        }
        brandService.save(brand);
        return "redirect:/brand/list";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        BrandEntity brand = brandService.findById(id);
        if (brand == null) {
            return "redirect:/brand/list";
        }
        model.addAttribute("brand", brand);
        model.addAttribute("statusList", getStatusList());
        return "brand/edit";  // Trả về trang chỉnh sửa thương hiệu
    }

    @PostMapping("/edit/{id}")
    public String editBrand(@PathVariable("id") Long id, @Valid @ModelAttribute("brand") BrandEntity brand,
                            BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("statusList", getStatusList());
            return "brand/edit";
        }
        brand.setId(id);
        brandService.save(brand);
        return "redirect:/brand/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteBrand(@PathVariable("id") Long id) {
        brandService.deleteById(id);
        return "redirect:/brand/list";
    }

    private List<Map<String, Object>> getStatusList() {
        List<Map<String, Object>> statusList = new ArrayList<>();

        Map<String, Object> active = new HashMap<>();
        active.put("id", 1);
        active.put("name", "Hoạt động");

        Map<String, Object> inactive = new HashMap<>();
        inactive.put("id", 0);
        inactive.put("name", "Không hoạt động");

        statusList.add(active);
        statusList.add(inactive);

        return statusList;
    }

    @ModelAttribute("statusMap")
    public Map<Integer, String> getStatusMap() {
        Map<Integer, String> statusMap = new HashMap<>();
        statusMap.put(1, "Hoạt động");
        statusMap.put(0, "Không hoạt động");
        return statusMap;
    }
}