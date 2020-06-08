package com.xueyouwang.xueyou.service;

import com.xueyouwang.xueyou.entity.Comment;
import com.xueyouwang.xueyou.utlis.Result;
import javax.servlet.http.HttpServletRequest;

public interface CommentService {

    //新增评论
    Result insertComment(Comment comment, HttpServletRequest request);
    //删除评论
    Result deleteComment(Long id, HttpServletRequest request);
    //根据话题id获取该话题的评论集合
    Result getTopicConversationComments(Long topicConversationId);

}
