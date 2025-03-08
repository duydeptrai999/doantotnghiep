package onmyownn.controller;

import onmyownn.model.entity.MaterialEntity;
import onmyownn.service.MaterialService;
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
public class MaterialController {

    @Autowired
    private MaterialService materialService;

    @RequestMapping("/material/list")
    public String listMaterials(@RequestParam(name = "page", defaultValue = "0") Integer page, Model model) {
        Pageable pageable = PageRequest.of(page, 5);
        Page<MaterialEntity> materials = materialService.findAll(pageable);
        model.addAttribute("materials", materials);
        return "material/list";
    }

    @RequestMapping("/material/add")
    public String showAddForm(Model model) {
        model.addAttribute("material", new MaterialEntity());
        model.addAttribute("statusList", getStatusList());
        return "material/add";
    }

    @RequestMapping("/material/save")
    public String addMaterial(@Valid @ModelAttribute("material") MaterialEntity material, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("statusList", getStatusList());
            return "material/add";
        }
        materialService.save(material);
        return "redirect:/material/list";
    }

    @RequestMapping("/material/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        MaterialEntity material = materialService.findById(id);
        if (material == null) {
            return "redirect:/material/list";
        }
        model.addAttribute("material", material);
        model.addAttribute("statusList", getStatusList());
        return "material/edit";
    }

    @RequestMapping("/material/update/{id}")
    public String editMaterial(@PathVariable("id") Long id, @Valid @ModelAttribute("material") MaterialEntity material,
                               BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("statusList", getStatusList());
            return "material/edit";
        }
        material.setId(id);
        materialService.save(material);
        return "redirect:/material/list";
    }

    @RequestMapping("/material/delete/{id}")
    public String deleteMaterial(@PathVariable("id") Long id) {
        materialService.deleteById(id);
        return "redirect:/material/list";
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