package com.dhu.service;

import com.dhu.dto.EmpDepartAtten;
import com.dhu.pojo.Attendance;
import java.sql.Date;
import java.util.List;

public interface AttendanceService {
    Attendance selectByIdAndDate(Attendance attendance);

    void updateOne(Attendance attendance);

    List<Attendance> selectListById(Integer id);

    List<EmpDepartAtten> selectEmpDepartAttenAll();

    void logout(Attendance attendance);

    List<EmpDepartAtten> selectByDay(Date signDay);

    List<EmpDepartAtten> selectAllById(int uid);
}
