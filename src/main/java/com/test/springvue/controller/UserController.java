package com.test.springvue.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.test.springvue.entity.User;
import com.test.springvue.mapper.UserMapper;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/user/{id}")
    public String getUserById(@PathVariable int id){
        return "根据id获取用户";
    }
//    @ApiOperation("添加用户")
//    @PostMapping("/user")
//    public String save(User user){
//        return "添加用户";
//    }
    @PutMapping("/user")
    public String update(User user){
        return "更新用户";
    }
    @DeleteMapping("/user")
    public String deleteById(@PathVariable int id){
        return "删除用户";
    }
    @GetMapping("/user")
    public List query(){
//        List<User> userList = userMapper.query();
        List<User> userList = userMapper.selectList(null);
        System.out.println(userList);
        return userList;
    }

    @PostMapping("/user")
    public String save(User user){
        int i = userMapper.insert(user);
        if (i>0){
            return "success";
        }else{
            return "false";
        }
    }
    @PostMapping("/user/findAll")
    public List<User> findAll(){
        return userMapper.selectAllUserAndOrders();
    }

    @PostMapping("/user/findByPage")
    public IPage findByPage(){
        Page<User> page = new Page<>(0,2);
        IPage ipage= userMapper.selectPage(page,null);
        return ipage;
    }
}

