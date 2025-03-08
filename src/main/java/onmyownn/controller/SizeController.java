package onmyownn.controller;

import onmyownn.model.entity.SizeEntity;
import onmyownn.service.SizeService;
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
public class SizeController {

    @Autowired
    private SizeService sizeService;

    @RequestMapping("/size/list")
    public String listSizes(@RequestParam(name = "page", defaultValue = "0") Integer page, Model model) {
        Pageable pageable = PageRequest.of(page, 5);
        Page<SizeEntity> sizes = sizeService.findAll(pageable);
        model.addAttribute("sizes", sizes);
        return "size/list";
    }

    @RequestMapping("/size/add")
    public String showAddForm(Model model) {
        model.addAttribute("size", new SizeEntity());
        model.addAttribute("statusList", getStatusList());
        return "size/add";
    }

    @RequestMapping("/size/save")
    public String addSize(@Valid @ModelAttribute("size") SizeEntity size, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("statusList", getStatusList());
            return "size/add";
        }
        sizeService.save(size);
        return "redirect:/size/list";
    }

    @RequestMapping("/size/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        SizeEntity size = sizeService.findById(id);
        if (size == null) {
            return "redirect:/size/list";
        }
        model.addAttribute("size", size);
        model.addAttribute("statusList", getStatusList());
        return "size/edit";
    }

    @RequestMapping("/size/update/{id}")
    public String editSize(@PathVariable("id") Long id, @Valid @ModelAttribute("size") SizeEntity size,
                           BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("statusList", getStatusList());
            return "size/edit";
        }
        size.setId(id);
        sizeService.save(size);
        return "redirect:/size/list";
    }

    @RequestMapping("/size/delete/{id}")
    public String deleteSize(@PathVariable("id") Long id) {
        sizeService.deleteById(id);
        return "redirect:/size/list";
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