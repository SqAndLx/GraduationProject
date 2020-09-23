package com.shiqing.myshiro.service.impl;

import com.shiqing.myshiro.bean.User;
import com.shiqing.myshiro.bean.vo.RolePrivilege;
import com.shiqing.myshiro.bean.vo.UserRole;
import com.shiqing.myshiro.dao.UserDao;
import com.shiqing.myshiro.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserDao userDao;

    @Override
    public List<UserRole> getUserRoleByName(String getMapByName) {
        List<UserRole> userRole = userDao.getUserRoleByName(getMapByName);
        return userRole;
    }

    @Override
    public List<RolePrivilege> getRolePrivilegeByRole(String role) {
        List<RolePrivilege> rolePrivilege = userDao.getRolePrivilegeByRole(role);
        return rolePrivilege;
    }

    @Override
    public User getUserByName(String name) {
        List<User> userByName = userDao.getUserByName(name);
        return userByName.get(0);
    }
}
