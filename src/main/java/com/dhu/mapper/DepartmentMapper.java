package com.dhu.mapper;

import com.dhu.pojo.Department;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import java.util.List;

//部门Mapper

@Mapper
@Repository
public interface DepartmentMapper {

    List<Department> selectAllDepartment();
    Department selectDepartment(int departmentId);
}
