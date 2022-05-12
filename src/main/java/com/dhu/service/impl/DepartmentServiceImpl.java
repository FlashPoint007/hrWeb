package com.dhu.service.impl;

// DepartmentServiceImpl


import com.dhu.mapper.DepartmentMapper;
import com.dhu.pojo.Department;
import com.dhu.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;

    @Override
    public List<Department> selectAllDepartment() {
        return departmentMapper.selectAllDepartment();
    }

    @Override
    public Department selectDepartment(int departmentId) {
        return departmentMapper.selectDepartment(departmentId);
    }

}