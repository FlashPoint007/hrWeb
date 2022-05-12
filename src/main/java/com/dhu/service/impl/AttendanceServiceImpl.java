package com.dhu.service.impl;

import com.dhu.dto.EmpDepartAtten;
import com.dhu.mapper.AttendanceMapper;
import com.dhu.pojo.Attendance;
import com.dhu.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.sql.Date;
import java.util.List;

@Service
public class AttendanceServiceImpl implements AttendanceService {
    @Autowired
    private AttendanceMapper attendanceMapper;

    @Override
    public Attendance selectByIdAndDate(Attendance attendance) {
        return attendanceMapper.selectByIdAndDate(attendance);
    }

    @Override
    public void updateOne(Attendance attendance) {
        attendanceMapper.updateOne(attendance);
    }

    @Override
    public List<Attendance> selectListById(Integer id) {
        return attendanceMapper.selectListById(id);
    }

    @Override
    public List<EmpDepartAtten> selectEmpDepartAttenAll() {
        return attendanceMapper.selectEmpDepartAttenAll();
    }

    @Override
    public void logout(Attendance attendance) {
        attendanceMapper.logout(attendance);
    }

    @Override
    public List<EmpDepartAtten> selectByDay(Date signDay) {
        return attendanceMapper.selectByDay(signDay);
    }

    @Override
    public List<EmpDepartAtten> selectAllById(int uid) {
        return attendanceMapper.selectAllById(uid);
    }
}
