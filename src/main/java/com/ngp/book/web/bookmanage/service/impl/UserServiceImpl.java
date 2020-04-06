package com.ngp.book.web.bookmanage.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.ngp.book.web.bookmanage.repository.UserMapper;
import com.ngp.book.web.bookmanage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.print.attribute.standard.JobSheets;

/**
 * @author gzd
 * @date 2020/4/5 下午10:11
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public JSONObject listUser(JSONObject jsonObject) {

        return null;
    }

    @Override
    public JSONObject getAllRoles() {
        return null;
    }

    @Override
    public JSONObject addUser(JSONObject jsonObject) {
        return null;
    }

    @Override
    public JSONObject updateUser(JSONObject jsonObject) {
        return null;
    }

    @Override
    public JSONObject listRole() {
        return null;
    }

    @Override
    public JSONObject listAllPermission() {
        return null;
    }

    @Override
    public JSONObject addRole(JSONObject jsonObject) {
        return null;
    }

    @Override
    public JSONObject updateRole(JSONObject jsonObject) {
        return null;
    }

    @Override
    public JSONObject deleteRole(JSONObject jsonObject) {
        return null;
    }
}
