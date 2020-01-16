package com.graduation.serviceImpl;

import com.graduation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.graduation.dao.UserMapper;
import com.graduation.mode.User;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User selectUser(String id) {
        return userMapper.selectUser(id);
    }
}
