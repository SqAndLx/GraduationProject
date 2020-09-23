package com.shiqing.myshiro.filter;

import com.shiqing.myshiro.utils.HttpUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

@Component
@Slf4j
public class MyAuthenticationFilter extends FormAuthenticationFilter {

    /**
     * 将自定义的filter注册 到spring管理
     * @param filter
     * @return
     */
    @Bean
    public FilterRegistrationBean registration(MyAuthenticationFilter filter) {
        FilterRegistrationBean registration = new FilterRegistrationBean(filter);
        registration.setEnabled(false);
        return registration;
    }

    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
        log.info("验证用户信息开始------------------start");
        HttpServletRequest req = (HttpServletRequest) request;
        String requestURI = req.getRequestURI();
        Subject subject = SecurityUtils.getSubject();
        //判断用户是否登陆
        boolean allowed = super.isAccessAllowed(request, response, mappedValue);
        if (!allowed) {
            // 判断请求是否是options请求
            String method = WebUtils.toHttp(request).getMethod();
            if (StringUtils.equalsIgnoreCase("OPTIONS", method)) {
                return true;
            }
            return false;
        }
        //本系统用户验证权限
        if (!requestURI.contains("/loginOut")) {
            boolean b = false;
            try {
                b = subject.isPermitted(HttpUtil.getURlFirstParagraph(requestURI));
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (!b) {
                throw new AuthorizationException("用户无权访问!");
            }
        }

//        //用户放入request中
//        TUser principal = (TUser) subject.getPrincipal();
//        //从缓存中获取用户更新session中的用户信息
//        req.getSession().setAttribute("user", userService.getCacheUser(principal.getcAccount()));
//        log.info("验证用户信息结束,用户{}------------------end", principal.getcAccount());
        return true;
    }

    /**
     * 如果isAccessAllowed返回false则会走onAccessDenied方法
     * @param request
     * @param response
     * @return
     * @throws Exception
     */

}
