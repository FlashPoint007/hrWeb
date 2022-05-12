package com.dhu.controller;

import com.dhu.dto.EmpAndWage;
import com.dhu.pojo.Department;
import com.dhu.pojo.Employee;
import com.dhu.pojo.User;
import com.dhu.service.DepartmentService;
import com.dhu.service.EmployeeService;
import com.dhu.service.WageService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class MyController {

    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private WageService wageService;
    @RequestMapping("/aboutMe")
    public String aboutMe(Model model){
        Subject subject = SecurityUtils.getSubject();
    User user = (User) subject.getPrincipal();
    Integer id = user.getId();
    EmpAndWage empAndWage=wageService.selectEmpAndWageById(id);
        Employee employee = employeeService.selectEmployeeById(id);
        model.addAttribute("emp",employee);
        model.addAttribute("uid",id);
    model.addAttribute("empAndWage",empAndWage);
        return "main";
    }
    @RequestMapping("/aboutMe2")
    public String aboutMe2(Model model){
        Subject subject = SecurityUtils.getSubject();
        User user = (User) subject.getPrincipal();
        Integer id = user.getId();
        EmpAndWage empAndWage=wageService.selectEmpAndWageById(id);
        Employee employee = employeeService.selectEmployeeById(id);
        model.addAttribute("emp",employee);
        model.addAttribute("uid",id);
        model.addAttribute("empAndWage",empAndWage);
        model.addAttribute("msg", "您今天已经签到过");
        return "main";
    }
    @RequestMapping("/aboutMe3")
    public String aboutMe3(Model model){
        Subject subject = SecurityUtils.getSubject();
        User user = (User) subject.getPrincipal();
        Integer id = user.getId();
        EmpAndWage empAndWage=wageService.selectEmpAndWageById(id);
        Employee employee = employeeService.selectEmployeeById(id);
        model.addAttribute("emp",employee);
        model.addAttribute("uid",id);
        model.addAttribute("empAndWage",empAndWage);
        model.addAttribute("msg", "您今天已经签退");
        return "main";
    }
    @RequestMapping("/aboutMe4")
    public String aboutMe4(Model model){
        Subject subject = SecurityUtils.getSubject();
        User user = (User) subject.getPrincipal();
        Integer id = user.getId();
        EmpAndWage empAndWage=wageService.selectEmpAndWageById(id);
        Employee employee = employeeService.selectEmployeeById(id);
        model.addAttribute("emp",employee);
        model.addAttribute("uid",id);
        model.addAttribute("empAndWage",empAndWage);
        model.addAttribute("msg", "请先签到");
        return "main";
    }
}
