package com.dhu.controller;
import com.dhu.dto.DepartmentDTO;
import com.dhu.dto.EmployeeDTO;
import com.dhu.pojo.Department;
import com.dhu.pojo.Document;
import com.dhu.pojo.Employee;
import com.dhu.service.DepartmentService;
import com.dhu.service.EmployeeService;
import com.dhu.service.UserService;
import com.dhu.service.WageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.*;


@Controller
public class EmployeeController {
@Autowired
private WageService wageService;
@Autowired
private EmployeeService employeeService;

@Autowired
private DepartmentService departmentService;

@Autowired
private UserService userService;
    //查询所有员工，返回列表页面
    @GetMapping("/emp")
    public String list(Model model){
        Collection<EmployeeDTO> employees = employeeService.selectAllEmployeeDTO();
        List<Department> departments = departmentService.selectAllDepartment();
        Collection<DepartmentDTO> departs=new ArrayList<>();
        for (int i=0;i<departments.size();i++){
            DepartmentDTO tmp = new DepartmentDTO(departments.get(i).getId(), departments.get(i).getDepartmentName(), employeeService.selectUserByDepartmentId(departments.get(i).getId()));
            departs.add(tmp);
        }
        //将结果放在请求中
        model.addAttribute("emps",employees);
        model.addAttribute("departs",departs);
        return "emp/list";
    }

    //员工添加页面
   @GetMapping("/add")
    public String toAdd(Model model){
        //查出所有的部门，提供选择
        Collection<Department> departments = departmentService.selectAllDepartment();
        model.addAttribute("departments",departments);
        return "emp/add";
    }

    //员工添加功能，使用post接收
    @PostMapping("/add")
    public String add(Employee employee){
        employee.setStatus(0);
        //保存员工信息
        employeeService.addEmployee(employee);
        //查询最新创建的员工编号
        int id=employeeService.selectNewEmp();
        //创建该员工工资
        wageService.addNewWageById(id);
        //回到员工列表页面，可以使用redirect或者forward
        Document document = new Document();
        document.setName(employee.getEmployeeName());
        Department department = departmentService.selectDepartment(employee.getDepartmentId());
        document.setRecords(department.getDepartmentName());
        document.setStaffNo(id);
        employeeService.addDocument(document);
        return "redirect:/emp";
    }

    //员工修改页面
    @GetMapping("/emp/{id}")
    public String toUpdateEmp(@PathVariable("id") Integer id, Model model){
        //根据id查出来员工
        Employee employee = employeeService.selectEmployeeById(id);
        //将员工信息返回页面
        model.addAttribute("emp",employee);
        //查出所有的部门，提供修改选择
        Collection<Department> departments = departmentService.selectAllDepartment();
        model.addAttribute("departments",departments);
        return "emp/update";
    }
    @PostMapping("/updateEmp")
    public String updateEmp(Employee employee){
        employeeService.updateEmployee(employee);
        Document document = employeeService.selectDoc(employee.getId());
        String records = document.getRecords();
        Scanner scanner = new Scanner(records);
        scanner.useDelimiter("->");
        String tmp = null;
        while(scanner.hasNext()){
            tmp=scanner.next();
        }
        if (!tmp.equals(departmentService.selectDepartment(employee.getDepartmentId()).getDepartmentName())){
            tmp=tmp+"->"+departmentService.selectDepartment(employee.getDepartmentId()).getDepartmentName();
        }
        document.setRecords(tmp);
        employeeService.updateDoc(document);
        //回到员工列表页面
        return "redirect:/emp";
    }

    @GetMapping("/delEmp/{id}")
    public String deleteEmp(@PathVariable("id")Integer id){
        //根据id删除员工
        Employee employee = employeeService.selectEmployeeById(id);
        if (employee.getStatus()==0){
            employeeService.deleteEmployee(id);
        }else{
            employeeService.recoverEmployee(id);
        }

        return "redirect:/emp";
    }

    @RequestMapping("/regist")
    public String regist(){
        return "regist";
    }

    @RequestMapping("/document")
    public String document(Model model){
        List<Document> documents = employeeService.selectAllDocs();
        model.addAttribute("docs",documents);
        return "emp/documentList";
    }
}
