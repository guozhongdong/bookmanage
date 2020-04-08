package com.ngp.book.web.bookmanage.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.ngp.book.web.bookmanage.config.PageInfo;
import com.ngp.book.web.bookmanage.config.PageRequest;
import com.ngp.book.web.bookmanage.dto.user.UserDTO;
import com.ngp.book.web.bookmanage.dto.user.UserQueryDto;
import com.ngp.book.web.bookmanage.repository.UserMapper;
import com.ngp.book.web.bookmanage.result.Result;
import com.ngp.book.web.bookmanage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author gzd
 * @date 2020/4/5 下午10:11
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public PageInfo listUser(PageRequest request) {
        PageInfo result = new PageInfo();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("offSet",request.getOffset());
        jsonObject.put("pageRow",request.getSize());
        List<JSONObject> userList =  userMapper.listUser(jsonObject);
        UserQueryDto userQueryDt = new UserQueryDto();

        result.setPageObjectList(userList);
        result.setPageSize(request.getPageSize());
        result.setPageNo(request.getPage());
        result.setTotal(userMapper.countUser(userQueryDt));
        return result;
    }

    @Override
    public Result getAllRoles() {
        Result result = new Result();
        result.setResult(userMapper.getAllRoles());
        return result;
    }

    @Override
    public Result addUser(UserDTO userDTO) {
        Result result = new Result();
        result.setResult(userMapper.addUser(userDTO));
        return result;
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
