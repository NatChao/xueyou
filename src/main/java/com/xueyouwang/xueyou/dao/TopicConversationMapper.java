package com.xueyouwang.xueyou.dao;

import com.xueyouwang.xueyou.entity.TopicConversation;

import java.util.List;

public interface TopicConversationMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TopicConversation record);

    int insertSelective(TopicConversation record);

    TopicConversation selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TopicConversation record);

    int updateByPrimaryKey(TopicConversation record);

    //获取所有话题
    List<TopicConversation> getAllTopicConversations();

    //获取个人用户的所有话题
    List<TopicConversation> getAllTopicConversationsByUser(Long userId);
}