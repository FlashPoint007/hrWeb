package com.dhu.service.impl;

import com.dhu.dto.EmployeeDTO;
import com.dhu.mapper.EmployeeMapper;
import com.dhu.pojo.Document;
import com.dhu.pojo.Employee;
import com.dhu.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//员工业务层实现类

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public List<EmployeeDTO> selectAllEmployeeDTO() {
        return employeeMapper.selectAllEmployeeDTO();
    }

    @Override
    public Employee selectEmployeeById(int id) {
        return employeeMapper.selectEmployeeById(id);
    }

    @Override
    public int addEmployee(Employee employee) {
        return employeeMapper.addEmployee(employee);
    }

    @Override
    public int updateEmployee(Employee employee) {
        return employeeMapper.updateEmployee(employee);
    }

    @Override
    public int deleteEmployee(int id) {
        return employeeMapper.deleteEmployee(id);
    }

    @Override
    public int recoverEmployee(int id) {
        return employeeMapper.recoverEmployee(id);
    }

    public void updateEmpStatusById(int id) {
        employeeMapper.updateEmpStatusById(id);
    }

    public void updateEmpStatus2ById(int id) {
        employeeMapper.updateEmpStatus2ById(id);

    }

    public void updateAllEmpStatus() {
        employeeMapper.updateAllEmpStatus();
    }

    public List<EmployeeDTO> selectEmpDtoByStatus() {
        return employeeMapper.selectEmpDtoByStatus();
    }

    @Override
    public int selectNewEmp() {

        return employeeMapper.selectNewEmp();
    }

    @Override
    public void updateSignById(int id) {
         employeeMapper.updateSignById(id);
    }

    @Override
    public void updateLaterById(int id) {
        employeeMapper.updateLaterById(id);
    }

    @Override
    public void addDocument(Document doc) {
        employeeMapper.addDocument(doc);
    }

    @Override
    public List<Document> selectAllDocs() {
        List<Document> documents = employeeMapper.selectAllDocs();
        return documents;
    }

    @Override
    public void updateDoc(Document doc) {
        employeeMapper.updateDoc(doc);
    }

    @Override
    public Document selectDoc(int staffNo) {
        return employeeMapper.selectDoc(staffNo);
    }

    @Override
    public int selectUserByDepartmentId(int id) {
        return employeeMapper.selectUserByDepartmentId(id);
    }


}
