package com.test.springvue.controller;

import com.test.springvue.entity.User;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @GetMapping("/user/{id}")
    public String getUserById(@PathVariable int id){
        return "根据id获取用户";
    }
    @ApiOperation("添加用户")
    @PostMapping("/user")
    public String save(User user){
        return "添加用户";
    }
    @PutMapping("/user")
    public String update(User user){
        return "更新用户";
    }
    @DeleteMapping("/user")
    public String deleteById(@PathVariable int id){
        return "删除用户";
    }
}

