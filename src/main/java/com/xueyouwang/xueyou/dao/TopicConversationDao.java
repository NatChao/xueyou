package com.xueyouwang.xueyou.dao;

import com.xueyouwang.xueyou.entity.TopicConversation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TopicConversationDao {

    //新增话题
    void insertTopicConversation(TopicConversation topicConversation);

    //删除话题
    int deleteTopicConversation(@Param("id") Long id);

    //更新话题
    int updateTopicConversation(TopicConversation topicConversation);

    //获取所有话题
    List<TopicConversation> getAllTopicConversations();

    //获取个人用户的所有话题
    List<TopicConversation> getAllTopicConversationsByUser(@Param("userId") Long userId);

    //根据id获取话题类
    TopicConversation getTopicConversation(Long id);
}
