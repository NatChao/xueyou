package com.xueyouwang.xueyou.service;

import com.xueyouwang.xueyou.entity.TopicConversation;
import com.xueyouwang.xueyou.utlis.Result;

public interface TopicConversationService {

    Result insertTopicConversation(TopicConversation topicConversation);

    Result deleteTopicConversation(Long id);

    Result updateTopicConversation(TopicConversation topicConversation, Long userId);

    Result getAllTopicConversations();
}
