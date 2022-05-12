package com.dhu.mapper;

import com.dhu.pojo.UserLeave;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import java.util.List;

@Mapper
@Repository
public interface UserLeaveMapper {

    void saveLeave(UserLeave userLeave);

    List<UserLeave> selectAllById(Integer id);

    List<UserLeave> selectAllLeave();

    void updateLeaveById(int id);

    void updateLeaveById2(int id);


}
