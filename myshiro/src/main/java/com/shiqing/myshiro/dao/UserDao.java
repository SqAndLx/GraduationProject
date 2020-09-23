package com.shiqing.myshiro.dao;

import com.shiqing.myshiro.bean.User;
import com.shiqing.myshiro.bean.vo.RolePrivilege;
import com.shiqing.myshiro.bean.vo.UserRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserDao {

    List<UserRole> getUserRoleByName(String name);

    List<RolePrivilege> getRolePrivilegeByRole(String role);

    List<User> getUserByName(@Param("name") String name);
}
