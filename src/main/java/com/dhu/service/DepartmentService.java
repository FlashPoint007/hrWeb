package com.dhu.service;

import com.dhu.pojo.Department;
import java.util.List;


//DepartmentService
public interface DepartmentService {
    List<Department> selectAllDepartment();
    Department selectDepartment(int departmentId);
}
