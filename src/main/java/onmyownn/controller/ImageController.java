package onmyownn.controller;

import onmyownn.model.entity.ImageEntity;
import onmyownn.service.ImageService;
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

@Controller
@RequestMapping("/image")
public class ImageController {

    @Autowired
    private ImageService imageService;

    @GetMapping("/list")
    public String listImages(@RequestParam(name = "page", defaultValue = "0") Integer page, Model model) {
        Pageable pageable = PageRequest.of(page, 5);
        Page<ImageEntity> images = imageService.findAll(pageable);
        model.addAttribute("images", images);
        return "image/list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("image", new ImageEntity());
        model.addAttribute("statusList", getStatusList());
        return "image/add";
    }

    @PostMapping("/add")
    public String addImage(@Valid @ModelAttribute("image") ImageEntity image, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("statusList", getStatusList());
            return "image/add";
        }
        imageService.save(image);
        return "redirect:/image/list";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        ImageEntity image = imageService.findById(id);
        if (image == null) {
            return "redirect:/image/list";
        }
        model.addAttribute("image", image);
        model.addAttribute("statusList", getStatusList());
        return "image/edit";
    }

    @PostMapping("/edit/{id}")
    public String editImage(@PathVariable("id") Long id, @Valid @ModelAttribute("image") ImageEntity image,
                            BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("statusList", getStatusList());
            return "image/edit";
        }
        image.setId(id);
        imageService.save(image);
        return "redirect:/image/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteImage(@PathVariable("id") Long id) {
        imageService.deleteById(id);
        return "redirect:/image/list";
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