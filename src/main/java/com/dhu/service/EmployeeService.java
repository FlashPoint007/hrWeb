package com.dhu.service;

import com.dhu.dto.EmployeeDTO;
import com.dhu.pojo.Document;
import com.dhu.pojo.Employee;

import java.util.List;

//description : 员工业务层接口

public interface EmployeeService {
    //查询全部员工信息
    List<EmployeeDTO> selectAllEmployeeDTO();
    //根据id查询员工信息
    Employee selectEmployeeById(int id);
    //添加一个员工信息
    int addEmployee(Employee employee);
    //修改一个员工信息
    int updateEmployee(Employee employee);
    //根据id删除员工信息
    int deleteEmployee(int id);
    int recoverEmployee(int id);

    int selectNewEmp();

    void updateSignById(int id);

    void updateLaterById(int id);

    void addDocument(Document doc);
    List<Document> selectAllDocs();
    void updateDoc(Document doc);
    Document selectDoc(int staffNo);

    int selectUserByDepartmentId(int id);

}
