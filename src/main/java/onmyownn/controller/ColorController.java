package onmyownn.controller;

import onmyownn.model.entity.ColorEntity;
import onmyownn.service.ColorService;
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
public class ColorController {

    @Autowired
    private ColorService colorService;

    @RequestMapping("/color/list")
    public String listColors(@RequestParam(name = "page", defaultValue = "0") Integer page, Model model) {
        Pageable pageable = PageRequest.of(page, 5);
        Page<ColorEntity> colors = colorService.findAll(pageable);
        model.addAttribute("colors", colors);
        return "color/list";
    }

    @RequestMapping("/color/add")
    public String showAddForm(Model model) {
        model.addAttribute("color", new ColorEntity());
        model.addAttribute("statusList", getStatusList());
        return "color/add";
    }

    @RequestMapping("/color/save")
    public String addColor(@Valid @ModelAttribute("color") ColorEntity color, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("statusList", getStatusList());
            return "color/add";
        }
        colorService.save(color);
        return "redirect:/color/list";
    }

    @RequestMapping("/color/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        ColorEntity color = colorService.findById(id);
        if (color == null) {
            return "redirect:/color/list";
        }
        model.addAttribute("color", color);
        model.addAttribute("statusList", getStatusList());
        return "color/edit";
    }

    @RequestMapping("/color/update/{id}")
    public String editColor(@PathVariable("id") Long id, @Valid @ModelAttribute("color") ColorEntity color,
                            BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("statusList", getStatusList());
            return "color/edit";
        }
        color.setId(id);
        colorService.save(color);
        return "redirect:/color/list";
    }

    @RequestMapping("/color/delete/{id}")
    public String deleteColor(@PathVariable("id") Long id) {
        colorService.deleteById(id);
        return "redirect:/color/list";
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