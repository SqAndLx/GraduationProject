package com.shiqing.myshiro.service;

import com.shiqing.myshiro.bean.User;
import com.shiqing.myshiro.bean.vo.RolePrivilege;
import com.shiqing.myshiro.bean.vo.UserRole;

import java.util.List;

public interface LoginService {

    List<UserRole> getUserRoleByName(String getMapByName);

    List<RolePrivilege> getRolePrivilegeByRole(String role);

    User getUserByName(String name);
}
