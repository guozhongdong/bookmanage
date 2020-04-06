package com.ngp.book.web.bookmanage.controller;

import com.alibaba.fastjson.JSONObject;
import com.ngp.book.web.bookmanage.config.PageInfo;
import com.ngp.book.web.bookmanage.config.PageRequest;
import com.ngp.book.web.bookmanage.dto.user.UserDTO;
import com.ngp.book.web.bookmanage.result.Result;
import com.ngp.book.web.bookmanage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author gzd
 * @date 2020/4/6 下午7:25
 */

@RestController
@RequestMapping("/user")
public class UserController {


    @Autowired
    private UserService userService;


    @GetMapping("/findAll/{page}/{size}")
    public PageInfo findAllUser(@PathVariable("page") Integer page, @PathVariable("size") Integer size){

        PageRequest request = new PageRequest();
        request.setSize(size);
        request.setPage((page-1)*size);
        return userService.listUser(request);
    }


    @PostMapping("/addUser")
    public Result addUser(@RequestBody UserDTO userDTO) {

        return userService.addUser(userDTO);
    }

}
