package com.dhu.service.impl;

import com.dhu.mapper.UserLeaveMapper;
import com.dhu.pojo.UserLeave;
import com.dhu.service.UserLeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserLeaveServiceImpl implements UserLeaveService {
@Autowired
UserLeaveMapper userLeaveMapper;
    @Override
    public void saveLeave(UserLeave userLeave) {
        userLeaveMapper.saveLeave(userLeave);
    }

    @Override
    public List<UserLeave> selectAllById(Integer id) {
        return userLeaveMapper.selectAllById(id);
    }

    @Override
    public List<UserLeave> selectAllLeave() {
        return userLeaveMapper.selectAllLeave();
    }

    @Override
    public void updateLeaveById(int id) {
        userLeaveMapper.updateLeaveById(id);
    }

    @Override
    public void updateLeaveById2(int id) {
        userLeaveMapper.updateLeaveById2(id);
    }
}
