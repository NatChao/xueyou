package com.xueyouwang.xueyou.Bean;

import com.xueyouwang.xueyou.entity.User;

//用户返回前端实体类
public class UserBO extends User {

    public void setUser(User user){
        this.setId(user.getId());
        this.setUserName(user.getUserName());
        this.setNickName(user.getNickName());
        this.setGender(user.getGender());
        this.setHeadPortrait(user.getHeadPortrait());
        this.setCreateTime(user.getCreateTime());
    }

    public UserBO() {

    }

    public UserBO(User user) {
        this.setUser(user);
    }

}
