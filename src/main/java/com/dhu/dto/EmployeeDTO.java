package com.dhu.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.sql.Date;

// EmployeeDTO
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {
    private Integer id;
    private String employeeName;
    private String email;
    private Integer gender;
    private String marriageStatus;
    private String politicalStatus;
    private String cultureStatus;
    private String major;
    private String departmentName;
    private Date date;
    private Integer empStatus;
    private int status;
}