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
    public int insertYg(User user) {
        userMapper.insertYg(user);
        return 1;
    }

    @Override
    public int deleteYg(String id) {
        userMapper.deleteYg(id);
        return 1;
    }

    @Override
    public int updateYg(User user) {
        userMapper.updateYg(user);
        return 1;
    }

    @Override
    public List<User> getYgxx() {
        List<User> list =userMapper.getYgxx();
        return list;
    }
}
