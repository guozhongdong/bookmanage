package com.ngp.book.web.bookmanage.config;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author gzd
 * @date 2020/4/11 下午8:03
 */
@Configuration
public class ShiroConfig {

    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager securityManager) {
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();

        //设置shiro的核心安全管理类

        bean.setSecurityManager(securityManager);
        /*
            anon: 无需认证就可访问
            authc：必须认证才能访问
            user：必须拥有记住我功能才能访问
            perms: 拥有对某个资源的权限才能访问
            role:拥有某个角色权限才能访问
       */
        /*Map<String, Filter> filterMap = new LinkedHashMap<>();
        // 授权，key是页面地址，value是shiro的权限信息
        //filterMap.put("/index/login", "perms:[user:add]");
        filterMap.put("authc", new AjaxPermissionsAuthorizationFilter());
        bean.setFilters(filterMap);*/

        /*定义shiro过滤链  Map结构
         * Map中key(xml中是指value值)的第一个'/'代表的路径是相对于HttpServletRequest.getContextPath()的值来的
         * anon：它对应的过滤器里面是空的,什么都没做,这里.do和.jsp后面的*表示参数,比方说login.jsp?main这种
         * authc：该过滤器下的页面必须验证后才能访问,它是Shiro内置的一个拦截器org.apache.shiro.web.filter.authc.FormAuthenticationFilter
         */
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
         /* 过滤链定义，从上向下顺序执行，一般将 / ** 放在最为下边:这是一个坑呢，一不小心代码就不好使了;
          authc:所有url都必须认证通过才可以访问; anon:所有url都都可以匿名访问 */
        filterChainDefinitionMap.put("/", "anon");
        filterChainDefinitionMap.put("/static/**", "anon");
        filterChainDefinitionMap.put("/login/auth", "anon");
        filterChainDefinitionMap.put("/login/logout", "anon");
        filterChainDefinitionMap.put("/error", "anon");
        filterChainDefinitionMap.put("/**", "anon");
        bean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        bean.setLoginUrl("/toLogin");
        return bean;

    }
    //DafaultWebSecurituManager
    @Bean(name="securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //关联UserRealm
        securityManager.setRealm(userRealm);

        return securityManager;
    }

    //创建realm对象 ，需要自定义
    @Bean(name = "userRealm")
    public UserRealm userRealm(){

        return new UserRealm();
    }
}
