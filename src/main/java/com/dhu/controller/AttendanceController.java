package com.dhu.controller;

import com.dhu.dto.EmpDepartAtten;
import com.dhu.pojo.Attendance;
import com.dhu.pojo.Employee;
import com.dhu.pojo.User;
import com.dhu.service.AttendanceService;
import com.dhu.service.EmployeeService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
//控制器
@Controller//考勤表
public class AttendanceController {
    private Attendance attendance1;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private AttendanceService attendanceService;
    @RequestMapping("/signOn/{id}")
    public String signOn(@PathVariable("id") int id,Model model){
        Date date = new Date(System.currentTimeMillis());
        Attendance attendance2 = new Attendance(null, id, date, null,null,null,null);
        Attendance attendance=attendanceService.selectByIdAndDate(attendance2);
        if(attendance!=null) {
            return "redirect:/aboutMe2";
        }
        Timestamp signTime = new Timestamp(System.currentTimeMillis());
        java.util.Date date1 = new java.util.Date(signTime.getTime());
        if(date1.getHours()>9&&date1.getMinutes()>0){//判断是否迟到
             attendance1 = new Attendance(null,id,date,signTime,0,null,null);
             employeeService.updateLaterById(id);
        }else{
            attendance1 = new Attendance(null,id,date,signTime,1,null,null);
            employeeService.updateSignById(id);
        }
        attendanceService.updateOne(attendance1);
        return "redirect:/mySign";
    }
    @RequestMapping("/mySign")
    public String mySign(Model model){
        Subject subject = SecurityUtils.getSubject();
        User user = (User) subject.getPrincipal();
        Integer id = user.getId();
        List<Attendance> attendanceList = attendanceService.selectListById(id);
        Employee employee = employeeService.selectEmployeeById(id);
        model.addAttribute("attendanceList",attendanceList);
        model.addAttribute("employee",employee);
        return "attendance/mySign";
    }
    @RequestMapping("/signList")
    public String signList(Model model){
       List<EmpDepartAtten> empDepartAttenList= attendanceService.selectEmpDepartAttenAll();
       model.addAttribute("edaList",empDepartAttenList);
        return "attendance/signList";
    }
    @RequestMapping("/logout/{id}")
    public String logout(@PathVariable("id")int id){
        Date date = new Date(System.currentTimeMillis());
        Attendance attendance = new Attendance(null, id, date, null,null,null,null);
        Attendance attendance2=attendanceService.selectByIdAndDate(attendance);
        if(attendance2==null){
            return "redirect:/aboutMe4";
        }
        if(attendance2.getLogStatus()!=null) {
            return "redirect:/aboutMe3";
        }
        java.util.Date date1 = new java.util.Date(new Timestamp(System.currentTimeMillis()).getTime());
        if(date1.getHours()<18) {//判断是否早退
            //正常打卡
            attendance1 = new Attendance(null, id, new Date(System.currentTimeMillis()), null, null, 1, new Timestamp(System.currentTimeMillis()));
        }else {
            attendance1 = new Attendance(null, id, new Date(System.currentTimeMillis()), null, null, 0, new Timestamp(System.currentTimeMillis()));

        }
        attendanceService.logout(attendance1);
        return "redirect:/mySign";
    }
    @RequestMapping("/findByDay")
    public String findByDay(Date signDay,Model model){
          List<EmpDepartAtten> empDepartAttenList =attendanceService.selectByDay(signDay);
          model.addAttribute("edaList",empDepartAttenList);
        return "attendance/signList";
    }
    @RequestMapping("/findById")
    public String findById(Model model,int uid){
        List<EmpDepartAtten> empDepartAttenList = attendanceService.selectAllById(uid);
        model.addAttribute("edaList",empDepartAttenList);
        return "attendance/signList";

    }
}
