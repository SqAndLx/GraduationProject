package com.shiqing.myshiro.config;

import com.shiqing.myshiro.filter.MyAuthenticationFilter;
import com.shiqing.myshiro.shiro.CustomRealm;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.crazycake.shiro.RedisCacheManager;
import org.crazycake.shiro.RedisManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import javax.servlet.Filter;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {

    @Resource
    private MyAuthenticationFilter myAuthenticationFilter;

    @Bean
    @ConditionalOnMissingBean
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator defaultAAP = new DefaultAdvisorAutoProxyCreator();
        defaultAAP.setProxyTargetClass(true);
        return defaultAAP;
    }

    /**
     * 将自己的验证方式加入容器
     *
     * @return
     */
    @Bean
    public CustomRealm myShiroRealm() {
        CustomRealm customRealm = new CustomRealm();
        //设置加密算法为MD5，并且进行2048次散列
        HashedCredentialsMatcher credentialsMatcher = new HashedCredentialsMatcher();
        credentialsMatcher.setHashAlgorithmName("md5");
        credentialsMatcher.setHashIterations(2048);
        customRealm.setCredentialsMatcher(credentialsMatcher);

        return customRealm;
    }

    /**
     * 权限管理，配置主要是Realm的管理认证
     *
     * @return
     */
    @Bean
    public SecurityManager securityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(myShiroRealm());
        securityManager.setCacheManager(cacheManager());
        return securityManager;
    }

    /**
     * cacheManager 缓存 redis实现
     * 使用的是shiro-redis开源插件
     *
     * @return
     */
    public RedisCacheManager cacheManager() {
        RedisCacheManager redisCacheManager = new RedisCacheManager();
        redisCacheManager.setRedisManager(redisManager());
        return redisCacheManager;
    }

    /**
     * 配置shiro redisManager
     * 使用的是shiro-redis开源插件
     *
     * @return
     */
    public RedisManager redisManager() {
        RedisManager redisManager = new RedisManager();
        redisManager.setHost("172.18.24.47");
        redisManager.setPort(6379);
        // 配置缓存过期时间
        redisManager.setExpire(1800);
        redisManager.setTimeout(300000);
        redisManager.setPassword("123456");
        return redisManager;
    }
    /**
     * Filter工厂，设置对应的过滤条件和跳转条件
     * anon:所有 url 都都可以匿名访问
     * authc: 需要认证才能进行访问
     * user:配置记住我或认证通过可以访问
     */
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        Map<String, String> map = new HashMap<>();

        //设置自定义的 登陆和鉴权的 过滤器
        Map<String, Filter> filters = shiroFilterFactoryBean.getFilters();
        filters.put("authc", myAuthenticationFilter);

        //登出
        map.put("/logout", "logout");
        map.put("/login", "anon");
        //对所有用户认证
        map.put("/**", "authc");

        //设置登录url
        shiroFilterFactoryBean.setLoginUrl("/login");
        //设置成功登录后跳转的首页
        shiroFilterFactoryBean.setSuccessUrl("/index");
        //设置认证不通过跳转错误页面
        shiroFilterFactoryBean.setUnauthorizedUrl("/error2");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);
        return shiroFilterFactoryBean;
    }


    /**
     * 开启shiro aop注解支持.
     * 使用代理方式;所以需要开启代码支持;
     *使授权注解起作用
     * @param securityManager
     * @return
     */
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }
}
