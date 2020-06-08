package com.xueyouwang.xueyou.Bean;

import com.xueyouwang.xueyou.entity.Comment;

//评论中间类
public class CommentBean extends Comment {
    private UserBO userBO;

    public UserBO getUserBO() {
        return userBO;
    }

    public void setUserBO(UserBO userBO) {
        this.userBO = userBO;
    }
}
