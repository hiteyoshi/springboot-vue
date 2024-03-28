package com.test.springvue.controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.test.springvue.entity.User;
import org.springframework.web.bind.annotation.*;

@RestController
public class ParameterController {

    @RequestMapping(value = "getTest1",method = RequestMethod.GET)
    public String getTest1(){
        return "GET 请求";
    }

    //    http://localhost:8080/getTset2?nickname=zhangsan&phone=123
    @RequestMapping(value = "getTest2",method = RequestMethod.GET)
    public String getTest2(String nickname, String phone){
        System.out.println("nickname:"+nickname);
        System.out.println("phone:"+phone);
        return "GET 请求";
    }

    //    http://localhost:8080/getTset2?nickname=zhangsan
    //    RequestParam 当参数名和url的参数名不一致时使用，required = false表示可以不传参
    @RequestMapping(value = "getTest3",method = RequestMethod.GET)
    public String getTest3(@RequestParam(value = "nickname",required = false) String name){
        System.out.println("nickname:"+name);
        return "GET 请求";
    }

    @RequestMapping(value ="postTest1",method = RequestMethod.POST)
    public String postTest1(){
        return "post 请求";
    }

    @RequestMapping(value = "postTest3",method = RequestMethod.POST)
    public String postTest3(User user){
        System.out.println(user);
        return "post 请求";
    }


}
