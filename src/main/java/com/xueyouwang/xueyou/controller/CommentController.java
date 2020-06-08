package com.xueyouwang.xueyou.controller;

import com.xueyouwang.xueyou.entity.Comment;
import com.xueyouwang.xueyou.service.CommentService;
import com.xueyouwang.xueyou.utlis.Result;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * 评论接口
 */
@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    /**
     * 新增评论接口
     * @param comment
     * @param request
     * @return
     */
    @PostMapping("/insert")
    public Result insertComment(@RequestBody Comment comment, HttpServletRequest request){
        return commentService.insertComment(comment, request);
    }

    /**
     * 删除评论接口
     * @param id
     * @param request
     * @return
     */
    @PutMapping("/delete")
    public Result deleteComment(@Param("id") Long id, HttpServletRequest request){
        return commentService.deleteComment(id, request);
    }

    /**
     * 根据话题id获取所有评论列表
     * @param topicConversationId
     * @return
     */
    @GetMapping("/getTopicConversationComments")
    public Result getTopicConversationComments(@Param("topicConversationId") Long topicConversationId){
        return commentService.getTopicConversationComments(topicConversationId);
    }

}
