package com.ngp.book.web.bookmanage.config;

import com.alibaba.fastjson.JSONObject;
import com.ngp.book.web.bookmanage.dto.user.UserDO;
import com.ngp.book.web.bookmanage.dto.user.UserDTO;
import com.ngp.book.web.bookmanage.result.Result;
import com.ngp.book.web.bookmanage.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author gzd
 * @date 2020/4/11 下午8:04
 */
public class UserRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    @Override
    /*
     * 权限授权
     * */
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        System.out.println("执行了=>授权doGetAuthorizationInfo");
        return null;
    }


    /*
     * 权限认证
     *  在LoginController 中把用户名和密码注册到 subject中，
     * */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {

        String loginName = (String) authcToken.getPrincipal();
        // 获取用户密码
        String password = new String((char[]) authcToken.getCredentials());
        UserDTO userDTO = new UserDTO();
        userDTO.setUsername(loginName);
        userDTO.setPassword(password);
        //BeanUtils.copyProperties(userDTO,userVo);
        //result = userService.getUser(userDTO);
        Result data = userService.getUser(userDTO);
        UserDO user = (UserDO) data.getResult();
        if (user == null) {
            //没找到帐号
            throw new UnknownAccountException();
        }
        //交给AuthenticatingRealm使用CredentialsMatcher进行密码匹配，如果觉得人家的不好可以自定义实现
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                user.getUsername(),
                user.getPassword(),
                //ByteSource.Util.bytes("salt"), salt=username+salt,采用明文访问时，不需要此句
                getName()
        );
        //session中不需要保存密码
        user.setPassword("");
        //将用户信息放入session中
        SecurityUtils.getSubject().getSession().setAttribute(Constants.SESSION_USER_INFO, user);
        return authenticationInfo;
    }
}
