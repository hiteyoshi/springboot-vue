package com.test.springvue.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

//    http://localhost:8080/hello?nickname=zhangsan&phone=123
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello(String nickname, String phone){
        return "hello world"+ nickname+" "+phone;
    }
}
