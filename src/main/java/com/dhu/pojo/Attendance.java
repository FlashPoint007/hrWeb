package com.dhu.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.sql.Date;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
//实体类
public class Attendance {
    private Integer id;
    private int uid;
    private Date signDay;
    private Timestamp signTime;
    private Integer signStatus;
    private Integer logStatus;
    private Timestamp logTime;
}
