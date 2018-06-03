package com.demo.service.impl;

import com.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.UserMapper;
import com.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean checkPhoneUnique(String phone) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Integer register(String phone, String pwd, String ip) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String login(String phone, String pwd, String from) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public User getUserById(int id) {
        return userMapper.selectByPrimaryKey(id);
    }
}
