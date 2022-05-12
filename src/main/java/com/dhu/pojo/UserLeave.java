package com.dhu.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.sql.Date;
//员工请假记录保存实体类
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserLeave {
    private int id;
    private String name;
    private String reason;
    private int leaveStatus;
    private String departmentName;
    private int employeeId;
    private Date startDate;
    private Date endDate;
}
