package com.xueyouwang.xueyou.controller;

import com.xueyouwang.xueyou.entity.TopicConversation;
import com.xueyouwang.xueyou.service.TopicConversationService;
import com.xueyouwang.xueyou.utlis.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 话题接口类
 */
@RestController
@RequestMapping("/topicConversation")
public class TopicConversationController {

    @Autowired
    private TopicConversationService topicConversationService;


    @RequestMapping("/insert")
    public Result insertTopicConversation(@RequestBody TopicConversation topicConversation, HttpRequest request){


        return null;
    }


}
