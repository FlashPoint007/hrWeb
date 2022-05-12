package com.dhu.mapper;

import com.dhu.dto.EmpAndWage;
import com.dhu.dto.EmployeeDTO;
import com.dhu.pojo.Document;
import com.dhu.pojo.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

//员工Mapper

@Mapper
@Repository
public interface EmployeeMapper {
    //查询全部员工信息
    List<EmployeeDTO> selectAllEmployeeDTO();

    //根据id查询员工信息
    Employee selectEmployeeById(@Param("id") Integer id);

    //添加一个员工信息
    int addEmployee(Employee employee);

    //修改一个员工信息
    int updateEmployee(Employee employee);

    //根据id删除员工信息
    int deleteEmployee(@Param("id") Integer id);

    int recoverEmployee(@Param("id") Integer id);

    void updateEmpStatusById(int id);

    void updateEmpStatus2ById(int id);

    void updateAllEmpStatus();

    List<EmployeeDTO> selectEmpDtoByStatus();

    int selectNewEmp();

    EmpAndWage selectEmpById(Integer id);

    void updateSignById(int id);

    void updateLaterById(int id);

    void addDocument(Document doc);
    List<Document> selectAllDocs();
    void updateDoc(Document doc);
    Document selectDoc(int staffNo);
    int selectUserByDepartmentId(int id);
}
