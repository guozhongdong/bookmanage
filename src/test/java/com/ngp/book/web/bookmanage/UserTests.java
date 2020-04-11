package com.ngp.book.web.bookmanage;



import com.alibaba.fastjson.JSONObject;
import com.ngp.book.web.bookmanage.dto.permission.PermissionDO;
import com.ngp.book.web.bookmanage.dto.role.RoleDO;
import com.ngp.book.web.bookmanage.dto.role.RoleDTO;
import com.ngp.book.web.bookmanage.dto.user.UserDTO;
import com.ngp.book.web.bookmanage.dto.user.UserQueryDto;

import com.ngp.book.web.bookmanage.repository.UserMapper;
import com.ngp.book.web.bookmanage.result.Result;
import com.ngp.book.web.bookmanage.service.LoginService;
import com.ngp.book.web.bookmanage.vo.UserVo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.InvocationTargetException;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class UserTests {


    @Autowired
    private UserMapper userMapper;

    @Autowired
    private LoginService loginService;

    @Test
    public void count() {
        UserQueryDto user = new UserQueryDto();
        user.setDeleteStatus("");
        int count = userMapper.countUser(user);
        log.info("分页查询结果为："+ JSONObject.toJSON(count));
    }

    @Test
    public void add() {
        UserDTO user = new UserDTO();
        user.setUsername("aaaa");
        user.setPassword("123456");
        user.setNickname("哈哈");
        user.setRoleId(1L);

        int count = userMapper.addUser(user);
        log.info("新增结果结果为："+ JSONObject.toJSON(count));
    }

    @Test
    public void update() {
        UserDTO user = new UserDTO();
        user.setUsername("aaaa122");
        user.setPassword("12345678");
        user.setNickname("哈哈11");
        user.setRoleId(1L);
        user.setDeleteStatus("1");
        user.setId(10008L);

        int count = userMapper.updateUser(user);
        log.info("修改结果结果为："+ JSONObject.toJSON(count));
    }


    @Test
    public void getAllRole() {


        List<RoleDO> list  = userMapper.getAllRoles();
        log.info("修改结果结果为："+ JSONObject.toJSON(list));
    }


    @Test
    public void listAllPermission() {


        List<PermissionDO> list  = userMapper.listAllPermission();
        log.info("修改结果结果为："+ JSONObject.toJSON(list));
    }

    @Test
    public void insertRole() {

        RoleDTO roleDTO = new RoleDTO();
        roleDTO.setRoleName("测试角色！");

        int count  = userMapper.insertRole(roleDTO);
        log.info("角色新增结果结果为："+ JSONObject.toJSON(count));
    }

    @Test
    public void updateRole() {

        RoleDTO roleDTO = new RoleDTO();
        roleDTO.setId(4);
        roleDTO.setRoleName("测试角色5555");

        int count  = userMapper.updateRoleName(roleDTO);
        log.info("角色新增结果结果为："+ JSONObject.toJSON(count));
    }


    @Test
    public void queryExistUsername() {

        UserDTO userDTO = new UserDTO();
        userDTO.setUsername("admin");


        int count  = userMapper.queryExistUsername(userDTO);
        log.info("角色新增结果结果为："+ JSONObject.toJSON(count));
    }


    @Test
    public void queryExistUsername1() {

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("offSet",1);
        jsonObject.put("pageRow",5);

        List<JSONObject> result  = userMapper.listUser(jsonObject);
        log.info("新增结果结果为："+ JSONObject.toJSON(result));
        int am = 1;
        System.out.println(am);
    }


    @Test
    public void userLogin() {

        UserVo userVo = new UserVo();
        userVo.setUsername("user");
        Result result = new Result();
        try {
            result = loginService.authLogin(userVo);
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        log.info("登录结果结果为："+ JSONObject.toJSON(result));
    }



}
