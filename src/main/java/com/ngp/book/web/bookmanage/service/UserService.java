package com.ngp.book.web.bookmanage.service;

import com.alibaba.fastjson.JSONObject;
import com.ngp.book.web.bookmanage.config.PageInfo;
import com.ngp.book.web.bookmanage.config.PageRequest;

import com.ngp.book.web.bookmanage.dto.user.UserDTO;
import com.ngp.book.web.bookmanage.result.Result;




/**
 * @author gzd
 * @date 2020/4/5 下午10:11
 */
public interface UserService {
    /**
     * 用户列表
     */
    PageInfo listUser(PageRequest request);

    /**
     * 查询所有的角色
     * 在添加/修改用户的时候要使用此方法
     */
    Result getAllRoles();

    /**
     * 添加用户
     */
    Result addUser(UserDTO userDTO) ;


    /**
     * 查询用户
     */
    Result getUser(UserDTO userDTO) ;

    /**
     * 修改用户
     */
    JSONObject updateUser(JSONObject jsonObject);

    /**
     * 角色列表
     */
    JSONObject listRole();

    /**
     * 查询所有权限, 给角色分配权限时调用
     */
    JSONObject listAllPermission();

    /**
     * 添加角色
     */
    JSONObject addRole(JSONObject jsonObject);

    /**
     * 修改角色
     */
    JSONObject updateRole(JSONObject jsonObject);

    /**
     * 删除角色
     */
    JSONObject deleteRole(JSONObject jsonObject);

}
