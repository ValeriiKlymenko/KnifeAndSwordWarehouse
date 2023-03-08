package com.knifeandsword.KnifeAndSwordWarehouse.controllers;

import com.knifeandsword.KnifeAndSwordWarehouse.entities.Material;
import com.knifeandsword.KnifeAndSwordWarehouse.enums.Type;
import com.knifeandsword.KnifeAndSwordWarehouse.repositories.MaterialRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Optional;

@Controller
@RequestMapping("material")
public class MaterialController {
    public final MaterialRepository materialRepository;
    public MaterialController(MaterialRepository materialRepository) {
        this.materialRepository = materialRepository;
    }

    @GetMapping("/")
    public String materialList(Model model){
        Iterable<Material> material = materialRepository.findAll();
        model.addAttribute("material", material);
        return "material";
    }

    @GetMapping("/add-material")
    public String materialAdd(Model model){
        return "add-material";
    }

    @PostMapping("/add-material")
    public String materialPostAdd(@RequestParam String name,
                                  @RequestParam int width,
                                  @RequestParam int height,
                                  @RequestParam int length,
                                  @RequestParam int weight,
                                  @RequestParam int amount,
                                  @RequestParam BigDecimal price,
                                  @RequestParam Type type,
                                  Model model){
        Material material = new Material(name, width, height, length, weight, amount, price, type);// потрібно створити конструктор в entity
        materialRepository.save(material);
        return "redirect:/material/";
    }
    @GetMapping("/material/{id}")
    public String materialDetails(@PathVariable(value = "id") long id, Model model){

        if (!materialRepository.existsById(id)){ // якщо немає такого id
            return "redirect:/material";
        }
        Optional<Material> material = materialRepository.findById(id);
        ArrayList<Material> res = new ArrayList<>();
        material.ifPresent(res::add);
        model.addAttribute("material", res);
        return "material-details";
    }
    @GetMapping("/material/{id}/edit")
    public String materialEdit(@PathVariable(value = "id") long id, Model model){

        if (!materialRepository.existsById(id)){ // якщо немає такого id
            return "redirect:/material/";
        }
        Optional<Material> material = materialRepository.findById(id);
        ArrayList<Material> res = new ArrayList<>();
        material.ifPresent(res::add);
        model.addAttribute("material", res);
        return "material-edit";
    }
    @PostMapping("/material/{id}/edit")
    public String materialPostUpdate(@PathVariable(value = "id") long id,
                                 @RequestParam String name,
                                 @RequestParam int width,
                                 @RequestParam int height,
                                 @RequestParam int length,
                                 @RequestParam int weight,
                                 @RequestParam int amount,
                                 @RequestParam BigDecimal price,
                                 @RequestParam Type type,
                                 Model model){
        Material material = materialRepository.findById(id).orElseThrow(); // виключення, якщо запис бул не найдений
        material.setName(name);
        material.setWidth(width);
        material.setHeight(height);
        material.setLength(length);
        material.setWeight(weight);
        material.setAmount(amount);
        material.setPrice(price);
        material.setType(type);
        materialRepository.save(material);
        return "redirect:/material/";
    }
    @PostMapping("/material/{id}/remove")
    public String materialPostDelete(@PathVariable(value = "id") long id, Model model){
        Material material = materialRepository.findById(id).orElseThrow();
        materialRepository.delete(material);

        return "redirect:/material/";
    }
}
