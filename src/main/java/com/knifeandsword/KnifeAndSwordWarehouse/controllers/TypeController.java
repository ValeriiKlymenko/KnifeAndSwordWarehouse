package com.knifeandsword.KnifeAndSwordWarehouse.controllers;

import com.knifeandsword.KnifeAndSwordWarehouse.entities.Type;
import com.knifeandsword.KnifeAndSwordWarehouse.repositories.TypeRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
        model.addAttribute("iron", type);
        return "type";
    }
}
