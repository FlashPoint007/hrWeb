package com.dhu.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.sql.Date;

//员工实体类

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    private Integer id;
    private String employeeName;
    private String email;
    private Integer gender; //0:女  1:男
    private String marriageStatus;
    private String politicalStatus;
    private String cultureStatus;
    private String major;
    private Date date;
    private Integer departmentId;
    private int empStatus;
    private int signCount;
    private int laterCount;
    private int status;


}
