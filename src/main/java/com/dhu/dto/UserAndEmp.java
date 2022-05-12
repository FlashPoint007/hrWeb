package com.dhu.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserAndEmp {
    private Integer id;
    private String employeeName;
    private String userName;
    private String perms;
}
