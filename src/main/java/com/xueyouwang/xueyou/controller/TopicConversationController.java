package com.xueyouwang.xueyou.controller;

import com.xueyouwang.xueyou.entity.TopicConversation;
import com.xueyouwang.xueyou.service.TopicConversationService;
import com.xueyouwang.xueyou.utlis.Result;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * 话题接口类
 */
@RestController
@RequestMapping("/topicConversation")
public class TopicConversationController {

    @Autowired
    private TopicConversationService topicConversationService;

    /**
     * 新建话题
     * @param topicConversation
     * @param request
     * @return
     */
    @PostMapping("/insert")
    public Result insertTopicConversation(TopicConversation topicConversation, HttpServletRequest request){
        return topicConversationService.insertTopicConversation(topicConversation, request);
    }

    /**
     * 删除话题
     * @param id
     * @param request
     * @return
     */
    @DeleteMapping("/delete")
    public Result deleteTopicConversation(@Param("id") Long id, HttpServletRequest request){
        return topicConversationService.deleteTopicConversation(id, request);
    }

    /**
     * 更改话题
     * @param topicConversation
     * @param request
     * @return
     */
    @PutMapping("/update")
    public Result updateTopicConversation(TopicConversation topicConversation, HttpServletRequest request){
        return topicConversationService.updateTopicConversation(topicConversation, request);
    }

    /**
     * 获取所有话题
     * @return
     */
    @GetMapping("/getAllTopicConversation")
    public Result getAllTopicConversation(){
        return topicConversationService.getAllTopicConversations();
    }

    /**
     * 获取单个话题及评论
     * @param id
     * @return
     */
    @GetMapping("/getTopicConversation")
    public Result getTopicConversation(@Param("id") Long id){
        return topicConversationService.getTopicConversation(id);
    }


}
