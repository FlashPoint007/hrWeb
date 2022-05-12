package com.dhu.controller;

import com.dhu.dto.UserAndEmp;
import com.dhu.pojo.Auth;
import com.dhu.pojo.User;
import com.dhu.service.AuthService;
import com.dhu.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    AuthService authService;
    @Autowired
    UserService userService;
    @GetMapping("/userList")
    public String selectAllUser(Model model){
        List<UserAndEmp> userList=userService.selectAllUser();
        model.addAttribute("userList",userList);
        return "emp/userList";
    }

    @GetMapping("/updateUser/{id}")
    public String updateUser(Model model,@PathVariable("id") int id){
        UserAndEmp user=userService.selectAllUserById(id);
        List<Auth> auths = authService.selectAllAuth();
        model.addAttribute("auths",auths);
        model.addAttribute("user",user);
        return "emp/add-perms";
    }

    @PostMapping("/updatePerms")
    public String updatePerms(User user){
        userService.updatePerms(user);
        return "redirect:/userList";
    }

   @GetMapping("/updatePassword")
    public String selectUserNow(Model model){
        //获取用户对象
       Subject subject = SecurityUtils.getSubject();
       User user = (User) subject.getPrincipal();
       model.addAttribute("user",user);
       return "emp/updatePassword";
   }

   @RequestMapping("/updatePasswordById")
    public String updatePassword(String password1,String password2,int id,Model model) throws InterruptedException {
       Subject subject = SecurityUtils.getSubject();
       User user = (User) subject.getPrincipal();
       Session session = subject.getSession();
       System.out.println("passsword==>"+password1);
       if(!password1.equals(password2)){
               model.addAttribute("msg","确认密码与密码不一致");
               model.addAttribute("user",user);
           return "emp/updatePassword";
       }
       model.addAttribute("user",user);
       User user1 = new User();
       user1.setPassword(password1);
       user1.setId(id);
       userService.updatePassword(user1);
       Thread.sleep(1000);
       return "emp/succeed";
    }
    @RequestMapping("/delById/{id}")
    public String delUserById(@PathVariable("id") int id){
        userService.delById(id);
        return "redirect:/userList";
    }
}
