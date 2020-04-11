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
        Result result = null;

        // 权限验证部分，暂且不处理
        /*Subject currentUser = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        try {
            currentUser.login(token);
            info.put("result", "success");
        } catch (AuthenticationException e) {
            info.put("result", "fail");
        }*/
        UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(userDTO,userVo);
        result = userService.getUser(userDTO);
        if (result.isSuccess() && result.getResult() != null){
            result.setMessage("登录成功！");
            return result;
        }else{
            result.setMessage("登录失败，重新登录！");
            result.setSuccess(false);
        }
        return result;
    }

    @Override
    public JSONObject getUser(String username, String password) {
        return null;
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
