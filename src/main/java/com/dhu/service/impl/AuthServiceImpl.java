package com.dhu.service.impl;

import com.dhu.mapper.AuthMapper;
import com.dhu.pojo.Auth;
import com.dhu.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthServiceImpl implements AuthService{
@Autowired
    AuthMapper authMapper;
    @Override
    public List<Auth> selectAllAuth() {
        return authMapper.selectAllAuth();
    }
}
