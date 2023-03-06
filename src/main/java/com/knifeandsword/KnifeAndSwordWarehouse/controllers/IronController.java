package com.knifeandsword.KnifeAndSwordWarehouse.controllers;

import com.knifeandsword.KnifeAndSwordWarehouse.entities.Iron;
import com.knifeandsword.KnifeAndSwordWarehouse.repositories.IronRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Optional;

@Controller
@RequestMapping("iron")
public class IronController {
    public final IronRepository ironRepository;
    public IronController(IronRepository ironRepository) {
        this.ironRepository = ironRepository;
    }

    @GetMapping("/")
    public String ironList(Model model){
        Iterable<Iron> iron = ironRepository.findAll();
        model.addAttribute("iron", iron);
        return "iron";
    }

    @GetMapping("/add-iron")
    public String ironAdd(Model model){
        return "add-iron";
    }

    @PostMapping("/add-iron")
    public String ironPostAdd(@RequestParam String name,
                              @RequestParam int width,
                              @RequestParam int height,
                              @RequestParam int length,
                              @RequestParam int weight,
                              @RequestParam int amount,
                              @RequestParam BigDecimal price,
                              Model model){
        Iron iron = new Iron(name, width, height, length, weight, amount, price);// потрібно створити конструктор в entity
        ironRepository.save(iron);
        return "redirect:/iron/";
    }
    @GetMapping("/iron/{id}")
    public String ironDetails(@PathVariable(value = "id") long id, Model model){

        if (!ironRepository.existsById(id)){ // якщо немає такого id
            return "redirect:/iron";
        }
        Optional<Iron> iron = ironRepository.findById(id);
        ArrayList<Iron> res = new ArrayList<>();
        iron.ifPresent(res::add);
        model.addAttribute("iron", res);
        return "iron-details";
    }
    @GetMapping("/iron/{id}/edit")
    public String ironEdit(@PathVariable(value = "id") long id, Model model){

        if (!ironRepository.existsById(id)){ // якщо немає такого id
            return "redirect:/iron/";
        }
        Optional<Iron> iron = ironRepository.findById(id);
        ArrayList<Iron> res = new ArrayList<>();
        iron.ifPresent(res::add);
        model.addAttribute("iron", res);
        return "iron-edit";
    }
    @PostMapping("/iron/{id}/edit")
    public String ironPostUpdate(@PathVariable(value = "id") long id,
                                 @RequestParam String name,
                                 @RequestParam int width,
                                 @RequestParam int height,
                                 @RequestParam int length,
                                 @RequestParam int weight,
                                 @RequestParam int amount,
                                 @RequestParam BigDecimal price,
                                 Model model){
        Iron iron = ironRepository.findById(id).orElseThrow(); // виключення, якщо запис бул не найдений
        iron.setName(name);
        iron.setWidth(width);
        iron.setHeight(height);
        iron.setLength(length);
        iron.setWeight(weight);
        iron.setAmount(amount);
        iron.setPrice(price);
        ironRepository.save(iron);
        return "redirect:/iron/";
    }
    @PostMapping("/iron/{id}/remove")
    public String ironPostDelete(@PathVariable(value = "id") long id, Model model){
        Iron iron = ironRepository.findById(id).orElseThrow();
        ironRepository.delete(iron);

        return "redirect:/iron/";
    }
}
