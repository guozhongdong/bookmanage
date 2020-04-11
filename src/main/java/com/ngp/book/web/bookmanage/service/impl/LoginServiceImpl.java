package com.ngp.book.web.bookmanage.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.ngp.book.web.bookmanage.dto.user.UserDO;
import com.ngp.book.web.bookmanage.dto.user.UserDTO;
import com.ngp.book.web.bookmanage.result.Result;
import com.ngp.book.web.bookmanage.service.LoginService;
import com.ngp.book.web.bookmanage.service.UserService;
import com.ngp.book.web.bookmanage.vo.UserVo;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;

/**
 * @author gzd
 * @date 2020/4/11 下午3:46
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserService userService;

    @Override
    public Result authLogin(UserVo userVo) throws InvocationTargetException, IllegalAccessException {
        Result result = new Result();

        // 权限验证部分，保存用户token，到权限认证处进行认证
        Subject currentUser = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(userVo.getUsername(), userVo.getPassword());
        try {
            currentUser.login(token);
            result.setMessage("登录成功！");
        } catch (AuthenticationException e) {
            result.setMessage("登录失败，重新登录！");
        }
        return result;
        //UserDTO userDTO = new UserDTO();
        //BeanUtils.copyProperties(userDTO,userVo);
        //result = userService.getUser(userDTO);
    }

    @Override
    public JSONObject getInfo() {
        return null;
    }

    @Override
    public JSONObject logout() {
        return null;
    }
}
