package com.dhu.service;

import com.dhu.pojo.UserLeave;

import java.util.List;

public interface UserLeaveService {
    void saveLeave(UserLeave userLeave);

    List<UserLeave> selectAllById(Integer id);

    List<UserLeave> selectAllLeave();

    void updateLeaveById(int id);

    void updateLeaveById2(int id);
}
