package com.knifeandsword.KnifeAndSwordWarehouse.controllers;

import com.knifeandsword.KnifeAndSwordWarehouse.entities.Type;
import com.knifeandsword.KnifeAndSwordWarehouse.repositories.TypeRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

@Controller
@RequestMapping("type")
public class TypeController {

    public final TypeRepository typeRepository;

    public TypeController(TypeRepository typeRepository) {
        this.typeRepository = typeRepository;
    }

    @GetMapping("/")
    public String typeList(Model model){
        Iterable<Type> type = typeRepository.findAll();
        model.addAttribute("type", type);
        return "type";
    }
    @GetMapping("/add-type")
    public String typeAdd(Model model){
        return "add-type.html";
    }

    @PostMapping("/add-type")
    public String typePostAdd(@RequestParam String name,
                                  Model model){
        Type type = new Type(name);// потрібно створити конструктор в entity
        typeRepository.save(type);
        return "redirect:/type/";
    }
}
