package com.dhu.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.sql.Date;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmpDepartAtten {
    private int uid;
    private Date signDay;
    private Timestamp signTime;
    private Integer signStatus;
    private String employeeName;
    private String departmentName;
    private Integer logStatus;
    private Timestamp logTime;
}
