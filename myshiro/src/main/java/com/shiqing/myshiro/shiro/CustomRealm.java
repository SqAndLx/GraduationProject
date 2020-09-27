package com.shiqing.myshiro.shiro;

import com.shiqing.myshiro.bean.User;
import com.shiqing.myshiro.bean.vo.RolePrivilege;
import com.shiqing.myshiro.bean.vo.UserRole;
import com.shiqing.myshiro.service.LoginService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 自定义的realm
 * 继承AuthorizingRealm 重写认证和鉴权方法
 */
public class CustomRealm extends AuthorizingRealm {
    @Autowired
    private LoginService loginService;

    private Logger logger = LoggerFactory.getLogger(CustomRealm.class);

    /**
     * 进行角色的添加和权限的添加
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        logger.info("开始添加权限--------------------------------");
        //获取登录用户名
        String name = (String) principalCollection.getPrimaryPrincipal();
        //根据用户名去数据库查询用户信息
        List<UserRole> user = loginService.getUserRoleByName(name);
        if (user == null) {
            throw new AuthorizationException("用户不存在！");
        }
        //添加角色和权限
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        for (UserRole userRole : user) {
            //添加角色
            simpleAuthorizationInfo.addRole(userRole.getCrole());
            //添加权限
            List<RolePrivilege> Privilege = loginService.getRolePrivilegeByRole(userRole.getCrole());
            if (Privilege == null) {
                throw new AuthorizationException("该用户没有设置权限");
            }
            for (RolePrivilege rolePrivile : Privilege) {
                simpleAuthorizationInfo.addStringPermission(rolePrivile.getCprivilegename());
            }
        }
        return simpleAuthorizationInfo;
    }

    /**
     * 重写获取用户信息的方法
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        logger.info("开始认证--------------------------------");
        if (authenticationToken.getPrincipal() == null) {
            return null;
        }
        //获取用户信息
        String name = (String) authenticationToken.getPrincipal();
        //获取密码、数字证书等
//        String password = new String((char[]) authenticationToken.getCredentials());
        User user = loginService.getUserByName(name);
        if (user == null) {
            //这里返回后会报出对应异常
            logger.error("获取用户信息失败");
            return null;
        } else {
            //参数1：数据库中的user（可以是对象也可以是username），可以用.getPrincipal()获取
            //参数2：从数据库获得的密码
            //参数3：盐（这里用的是用户名）
            //参数4：realm的名字
            SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(
                    name,
                    user.getCpassword(),
                    ByteSource.Util.bytes(name),
                    getName());
            return simpleAuthenticationInfo;
        }
    }

}
