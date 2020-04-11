package com.ngp.book.web.bookmanage.repository;

import com.alibaba.fastjson.JSONObject;
import com.ngp.book.web.bookmanage.dto.permission.PermissionDO;
import com.ngp.book.web.bookmanage.dto.role.RoleDO;
import com.ngp.book.web.bookmanage.dto.role.RoleDTO;
import com.ngp.book.web.bookmanage.dto.user.UserDO;
import com.ngp.book.web.bookmanage.dto.user.UserDTO;
import com.ngp.book.web.bookmanage.dto.user.UserQueryDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author gzd
 * @date 2020/4/5 下午10:07
 */
public interface UserMapper {

    /**
     * 查询用户数量
     */
    int countUser(UserQueryDto userQuery);

    /**
     * 新增用户
     */
    int addUser(UserDTO userDTO);

    /**
     * 查询用户
     */
    UserDO getUser(UserDTO userDTO);

    /**
     * 修改用户
     */
    int updateUser(UserDTO userDTO);


    /**
     * 查询所有的角色
     * 在添加/修改用户的时候要使用此方法
     */
    List<RoleDO> getAllRoles();


    /**
     * 查询所有权限, 给角色分配权限时调用
     */
    List<PermissionDO> listAllPermission();



    /**
     * 新增角色
     */
    int insertRole(RoleDTO roleDTO);

    /**
     * 修改角色名称
     */
    int updateRoleName(RoleDTO roleDTO);


    /**
     * 删除角色
     */
    int removeRole(RoleDTO roleDTO);


    /**
     * 删除本角色全部权限
     */
    int removeRoleAllPermission(RoleDTO roleDTO);

    /**
     * 校验用户名是否已存在
     */
    int queryExistUsername(UserDTO userDTO);


    /**
     * 查询用户列表
     */
    List<JSONObject> listUser(JSONObject jsonObject);


    /**
     * 查询某角色的全部数据
     * 在删除和修改角色时调用
     */
    JSONObject getRoleAllInfo(JSONObject jsonObject);


    /**
     * 角色列表
     */
    List<JSONObject> listRole();


    /**
     * 批量插入角色的权限
     *
     * @param roleId      角色ID
     * @param permissions 权限
     */
    int insertRolePermission(@Param("roleId") String roleId, @Param("permissions") List<Integer> permissions);

    /**
     * 将角色曾经拥有而修改为不再拥有的权限 delete_status改为'2'
     */
    int removeOldPermission(@Param("roleId") String roleId, @Param("permissions") List<Integer> permissions);

}
