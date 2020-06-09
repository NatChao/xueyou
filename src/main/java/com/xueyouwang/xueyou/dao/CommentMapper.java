package com.xueyouwang.xueyou.dao;

import com.xueyouwang.xueyou.entity.Comment;

import java.util.List;

public interface CommentMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Comment record);

    int insertSelective(Comment record);

    Comment selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Comment record);

    int updateByPrimaryKey(Comment record);

    int deleteComment(Long id);

    //根据话题id获取所有该话题下的评论
    List<Comment> getTopicConversationComments(Long topicConversationId);
}