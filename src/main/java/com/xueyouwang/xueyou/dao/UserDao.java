package com.xueyouwang.xueyou.dao;

import com.xueyouwang.xueyou.entity.User;
import org.apache.ibatis.annotations.Param;

public interface UserDao {

    //保存用户方法
    void save(User user);

    //根据用户名查询账户
    User selectUserName(@Param("userName") String userName);

    //根据用户id查询
    User selectUserById(Long id);
}
