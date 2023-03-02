package com.knifeandsword.KnifeAndSwordWarehouse.controllers;

import com.knifeandsword.KnifeAndSwordWarehouse.entities.Iron;
import com.knifeandsword.KnifeAndSwordWarehouse.services.IronService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("iron")
public class IronController {

    public final IronService ironService;

    public IronController(IronService ironService) {
        this.ironService = ironService;
    }

    @GetMapping("list")
    public List<Iron> listIron() {
        return ironService.listIron();
    }

    @GetMapping("/")
    public String ironList() {
        return "ironList";
    }
}
