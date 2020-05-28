package com.xueyouwang.xueyou.controller;

import com.xueyouwang.xueyou.entity.Result;
import com.xueyouwang.xueyou.entity.User;
import com.xueyouwang.xueyou.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController()
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 用户注册接口
     * @param user
     * @return
     */
    @RequestMapping(value = "/register", method = POST)
    public Result register(@RequestBody User user){
        System.out.println("user :" + user);
        return userService.register(user);
    }

    /**
     * 用户登录接口
     * @param user
     * @return
     */
    @RequestMapping(value = "/login", method = POST)
    public Result login(@RequestBody User user){

        return null;
    }

}
