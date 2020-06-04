package com.xueyouwang.xueyou.service;

import com.xueyouwang.xueyou.utlis.Result;
import com.xueyouwang.xueyou.entity.User;

public interface UserService {

    //用户登入
    Result login(User user);

    //用户注册
    Result register(User user);

}
