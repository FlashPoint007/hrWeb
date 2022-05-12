package com.dhu.service.impl;

import com.dhu.dto.UserAndEmp;
import com.dhu.mapper.UserMapper;
import com.dhu.pojo.User;
import com.dhu.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// UserServiceImpl

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User selectPasswordByName(String userName) {
        return userMapper.selectPasswordByName(userName);
    }

    @Override
    public void saveUsernameAndPassword(User user) {
        userMapper.saveUsernameAndPassword(user);
    }

    @Override
    public List<UserAndEmp> selectAllUser() {
        return userMapper.selectAllUser();
    }

    @Override
    public UserAndEmp selectAllUserById(int id) {
        return userMapper.selectAllUserById(id);
    }

    @Override
    public void updatePerms(User user) {
        userMapper.updatePerms(user);
    }


    @Override
    public User selectUserById(Integer id) {
        return userMapper.selectUserById(id);
    }

    @Override
    public void updatePassword(User user) {
        userMapper.updatePassword(user);
    }

    @Override
    public String selectPermsByName(String username) {
        return userMapper.selectPermsByName(username);
    }

    @Override
    public void delById(Integer id) {
        userMapper.delById(id);
    }
}
