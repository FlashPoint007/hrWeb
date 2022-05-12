package com.dhu.mapper;

import com.dhu.dto.EmpDepartAtten;
import com.dhu.pojo.Attendance;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.sql.Date;
import java.util.List;
//dao层
@Mapper
@Repository
public interface AttendanceMapper {

    Attendance selectByIdAndDate(Attendance attendance);

    void updateOne(Attendance attendance);

    List<Attendance> selectListById(Integer id);

    List<EmpDepartAtten> selectEmpDepartAttenAll();

    void logout(Attendance attendance);

    List<EmpDepartAtten> selectByDay(@Param("signDay")Date signDay);

    List<EmpDepartAtten> selectAllById(@Param("uid") int uid);
}
