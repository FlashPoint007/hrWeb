package com.dhu.controller;

import com.dhu.dto.EmpAndWage;
import com.dhu.service.WageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collection;

@Controller
public class WageController {
    @Autowired
    WageService wageService;
    @GetMapping("/salary")
    public String listSalary(Model model){
        Collection<EmpAndWage> salaryList = wageService.selectEmpAndWage();
       //将结果放在请求中
        model.addAttribute("salarys",salaryList);
        return "emp/salary";
    }
    @GetMapping("/salary/{id}")
    public String toUpdateWage(@PathVariable("id") int id, Model model){
        EmpAndWage empAndWage = wageService.selectEmpAndWageById(id);
        model.addAttribute("salary",empAndWage);
        return "emp/update-wage";
    }

    @PostMapping("/updateWage")
    public String updateWage(EmpAndWage empAndWage){
        wageService.updateEmpAndWage(empAndWage);
        //回到员工列表页面
        return "redirect:/salary";
    }
}
