package com.dhu.controller;

import com.dhu.pojo.Employee;
import com.dhu.pojo.User;
import com.dhu.service.EmployeeService;
import com.dhu.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpSession;


//登录
@Controller
public class LoginController {
    @Autowired
    private UserService userService;
    @Autowired
    private EmployeeService employeeService;
    @RequestMapping("/login")
    public String login() {
        return "redirect:/index.html";
    }
    @RequestMapping("/login2")
    public String login2(String username, String password, Model model) {
        //获取当前用户
        Subject subject = SecurityUtils.getSubject();
        //封装用户的登录信息
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        String perms = userService.selectPermsByName(username);
        System.out.println("perms==>"+perms);
            if ("user:freeze".equals(perms)) {
                model.addAttribute("msg", "你的账号已被冻结，请联系管理员");
                return "index";
            }
        try {
            subject.login(token);
            return "redirect:/aboutMe";
        } catch (UnknownAccountException e) {//用户名不存在
            model.addAttribute("msg", "用户名错误");
            return "index";
        } catch (IncorrectCredentialsException e) {//密码不存在
            model.addAttribute("msg", "密码错误");
            return "index";
        }

    }
    @GetMapping("/loginOut")
    public String loginOut(HttpSession session) {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "redirect:/index.html";
    }

    //定制未授权页面
    @RequestMapping("/noauth")
    @ResponseBody
    public String noauth() {
        return "未经授权，无法访问该页面";
    }

    @RequestMapping("/save")
    public String sava(User user, Model model) {
        User user1 = userService.selectPasswordByName(user.getUserName());
        if (user1 != null) {
            model.addAttribute("msg", "用户名已存在");
            return "regist";
        }
        User user2 = userService.selectUserById(user.getId());
        Employee employee = employeeService.selectEmployeeById(user.getId());
        if (employee == null) {
            model.addAttribute("msg", "不存在此员工");
            return "regist";
        }
        if (user2 != null) {
            model.addAttribute("msg", "此员工已注册账号");
            return "regist";
        }
        userService.saveUsernameAndPassword(user);
        return "index";
    }
}
