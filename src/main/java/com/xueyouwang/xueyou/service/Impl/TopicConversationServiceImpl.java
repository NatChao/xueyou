package com.xueyouwang.xueyou.service.Impl;

import com.xueyouwang.xueyou.dao.TopicConversationMapper;
import com.xueyouwang.xueyou.entity.TopicConversation;
import com.xueyouwang.xueyou.entity.User;
import com.xueyouwang.xueyou.response.ResponseResult;
import com.xueyouwang.xueyou.service.TopicConversationService;
import com.xueyouwang.xueyou.utlis.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 话题实现类
 */
@Service
public class TopicConversationServiceImpl implements TopicConversationService {

    @Autowired
    private TopicConversationMapper topicConversationMapper;

    @Override
    public Result insertTopicConversation(TopicConversation topicConversation, HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        if (user != null){
            topicConversation.setUserId(user.getId());
            topicConversation.setCreateTime(LocalDateTime.now());
            topicConversationMapper.insertSelective(topicConversation);
            return ResponseResult.genSuccessResult();
        }else {
            return ResponseResult.genFailResult("创建话题失败，请登录后重试。");
        }
    }

    @Override
    public Result deleteTopicConversation(Long id, HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        if (user != null){
            topicConversationMapper.deleteByPrimaryKey(id);
            return ResponseResult.genSuccessResult();
        }else {
            return ResponseResult.genFailResult("删除话题失败，请登录后重试。");
        }
    }

    @Override
    public Result updateTopicConversation(TopicConversation topicConversation, HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        if (user != null){
            topicConversationMapper.updateByPrimaryKeySelective(topicConversation);
            return ResponseResult.genSuccessUpdateResult();
        }else {
            return ResponseResult.genFailResult("更改话题失败，请登录后重试。");
        }
    }

    @Override
    public Result getAllTopicConversations() {
            List<TopicConversation> allTopicConversations = topicConversationMapper.getAllTopicConversations();
            return ResponseResult.genSuccessResult(allTopicConversations);
    }

    @Override
    public Result getTopicConversation(Long id) {
        TopicConversation topicConversation = topicConversationMapper.selectByPrimaryKey(id);
        return ResponseResult.genSuccessResult(topicConversation);
    }

    @Override
    public Result getRotationChart() {
        List<TopicConversation> rotationChartList = topicConversationMapper.getRotationChart();
        return ResponseResult.genSuccessResult(rotationChartList);
    }
}
