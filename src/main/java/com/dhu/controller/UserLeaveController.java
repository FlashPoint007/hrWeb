package com.dhu.controller;

import com.dhu.dto.EmpAndWage;
import com.dhu.pojo.Department;
import com.dhu.pojo.User;
import com.dhu.pojo.UserLeave;
import com.dhu.service.DepartmentService;
import com.dhu.service.UserLeaveService;
import com.dhu.service.WageService;
import lombok.experimental.PackagePrivate;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class UserLeaveController {
    @Autowired
    private UserLeaveService userLeaveService;
    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private WageService wageService;
    @GetMapping("/leave")
    public String leave(Model model){
        Subject subject = SecurityUtils.getSubject();
        User user = (User) subject.getPrincipal();
        Integer id = user.getId();
        EmpAndWage empAndWage=wageService.selectEmpAndWageById(id);
        model.addAttribute("empAndWage2",empAndWage);
        List<Department> departments = departmentService.selectAllDepartment();
        model.addAttribute("departments",departments);
        return "emp/leave";
    }
    @RequestMapping("/leaveAsk")
    public String leaveAsk(UserLeave userLeave){
        userLeaveService.saveLeave(userLeave);
        return "redirect:/leaveList";
    }

    @RequestMapping("/leaveList")
    public String leaveList(Model model){
        Subject subject = SecurityUtils.getSubject();
        User user = (User) subject.getPrincipal();
        Integer id = user.getId();
        List<UserLeave> leaveList=userLeaveService.selectAllById(id);
        model.addAttribute("leaveList",leaveList);
        return "emp/leavelist";
    }

    @RequestMapping("/leaveListAll")
    public String leaveListAll(Model model){
        List<UserLeave> leaveList=userLeaveService.selectAllLeave();
        model.addAttribute("leaveList",leaveList);
        return "emp/leavemanage";
    }

    @RequestMapping("/leaveUpdate/{id}")
    public String leaveupdate(@PathVariable("id") int id){
        userLeaveService.updateLeaveById(id);
        return "redirect:/leaveListAll";
    }

    @RequestMapping("/leaveUpdate2/{id}")
    public String leaveupdate2(@PathVariable("id") int id){
        userLeaveService.updateLeaveById2(id);
        return "redirect:/leaveListAll";
    }
}
