package com.xueyouwang.xueyou.controller;

import com.xueyouwang.xueyou.entity.Result;
import com.xueyouwang.xueyou.entity.User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController()
@RequestMapping("/user")
public class UserController {

    @RequestMapping(value = "/login", method = POST)
    public Result login(@RequestBody User user){

        return null;

    }




}
