package com.xueyouwang.xueyou.service;

import com.xueyouwang.xueyou.entity.TopicConversation;
import com.xueyouwang.xueyou.utlis.Result;

import javax.servlet.http.HttpServletRequest;

public interface TopicConversationService {

    Result insertTopicConversation(TopicConversation topicConversation, HttpServletRequest request);

    Result deleteTopicConversation(Long id);

    Result updateTopicConversation(TopicConversation topicConversation, Long userId);

    Result getAllTopicConversations();
}
