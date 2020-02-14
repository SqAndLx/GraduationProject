package com.graduation.serviceImpl;

import com.graduation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.graduation.dao.UserMapper;
import com.graduation.mode.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 根据id查寻用户信息
     * @param id
     * @return
     */
    @Override
    public User selectUserById(String id) {
        return userMapper.selectUserById(id);
    }

    @Override
    public void insertYg(User user) {
        userMapper.insertYg(user);
    }

    @Override
    public void deleteYg(String id) {
        userMapper.deleteYg(id);
    }

    @Override
    public void updateYg(User user) {
        userMapper.updateYg(user);
    }

    @Override
    public List<User> getYgxx() {
        List<User> list =userMapper.getYgxx();
        return list;
    }
}
