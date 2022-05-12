package com.dhu.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmpAndWage {
    private Integer id;
    private String employeeName;
    private String email;
    private Integer gender;
    private String departmentName;
    private double salary;
}