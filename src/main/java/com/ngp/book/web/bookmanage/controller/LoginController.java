package com.ngp.book.web.bookmanage.controller;

import com.alibaba.fastjson.JSONObject;
import com.ngp.book.web.bookmanage.dto.user.UserDTO;
import com.ngp.book.web.bookmanage.result.Result;
import com.ngp.book.web.bookmanage.service.LoginService;
import com.ngp.book.web.bookmanage.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.InvocationTargetException;

/**
 * @author gzd
 * @date 2020/4/11 下午3:43
 * 登录控制器
 */
@RestController
@RequestMapping("/login")
public class LoginController {


    @Autowired
    private LoginService loginService;

    /**
     * 登录
     */
    @PostMapping("/auth")
    public Result authLogin(@RequestBody UserVo userVo) {
        Result result = new Result();

        if (userVo.getUsername() == null){
            result.setMessage("请输入用户名！");
            return result;
        }
        if (userVo.getPassword() == null){
            result.setMessage("请输入密码！");
            return result;
        }
        try {
            return loginService.authLogin(userVo);
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 查询当前登录用户的信息
     */
    @PostMapping("/getInfo")
    public JSONObject getInfo() {
        return loginService.getInfo();
    }

    /**
     * 登出
     */
    @PostMapping("/logout")
    public JSONObject logout() {
        return loginService.logout();
    }
}
