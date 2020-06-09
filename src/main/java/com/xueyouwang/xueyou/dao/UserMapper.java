package com.xueyouwang.xueyou.dao;

import com.xueyouwang.xueyou.entity.User;

public interface UserMapper {

    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    //根据用户名查询账户
    User selectUserName(String userName);
}