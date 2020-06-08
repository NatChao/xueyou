package com.xueyouwang.xueyou.service;

import com.xueyouwang.xueyou.utlis.Result;
import com.xueyouwang.xueyou.entity.User;

import javax.servlet.http.HttpServletRequest;

public interface UserService {

    //用户登入
    Result login(User user, HttpServletRequest request);

    //用户注册
    Result register(User user);

    //用户注销
    Result cancellation(HttpServletRequest request);
}
