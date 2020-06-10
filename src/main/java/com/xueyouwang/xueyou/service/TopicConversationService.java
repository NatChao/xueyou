package com.xueyouwang.xueyou.service;

import com.xueyouwang.xueyou.entity.TopicConversation;
import com.xueyouwang.xueyou.utlis.Result;

import javax.servlet.http.HttpServletRequest;

public interface TopicConversationService {

    Result insertTopicConversation(TopicConversation topicConversation, HttpServletRequest request);

    Result deleteTopicConversation(Long id, HttpServletRequest request);

    Result updateTopicConversation(TopicConversation topicConversation, HttpServletRequest request);

    Result getAllTopicConversations();

    Result getTopicConversation(Long id);

    Result getRotationChart();
}
