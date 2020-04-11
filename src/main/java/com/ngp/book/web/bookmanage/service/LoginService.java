package com.ngp.book.web.bookmanage.service;

import com.alibaba.fastjson.JSONObject;
import com.ngp.book.web.bookmanage.result.Result;
import com.ngp.book.web.bookmanage.vo.UserVo;

import java.lang.reflect.InvocationTargetException;

/**
 * @author gzd
 * @date 2020/4/11 下午3:45
 */
public interface LoginService {

    /**
     * 登录表单提交
     */
    Result authLogin(UserVo userVo) throws InvocationTargetException, IllegalAccessException;



    /**
     * 查询当前登录用户的权限等信息
     */
    JSONObject getInfo();

    /**
     * 退出登录
     */
    JSONObject logout();
}
