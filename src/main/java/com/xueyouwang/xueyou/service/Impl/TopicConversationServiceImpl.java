package com.xueyouwang.xueyou.service.Impl;

import com.xueyouwang.xueyou.dao.TopicConversationDao;
import com.xueyouwang.xueyou.entity.TopicConversation;
import com.xueyouwang.xueyou.entity.User;
import com.xueyouwang.xueyou.response.ResponseResult;
import com.xueyouwang.xueyou.service.TopicConversationService;
import com.xueyouwang.xueyou.utlis.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

/**
 * 话题实现类
 */
@Service
public class TopicConversationServiceImpl implements TopicConversationService {

    @Autowired
    private TopicConversationDao topicConversationDao;

    @Override
    public Result insertTopicConversation(TopicConversation topicConversation, HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        if (user != null){
            topicConversation.setUserId(user.getId());
            topicConversation.setCreateTime(LocalDateTime.now());
            topicConversationDao.insertTopicConversation(topicConversation);
            return ResponseResult.genSuccessResult();
        }
        return ResponseResult.genFailResult("创建话题失败");
    }

    @Override
    public Result deleteTopicConversation(Long id) {
        return null;
    }

    @Override
    public Result updateTopicConversation(TopicConversation topicConversation, Long userId) {
        return null;
    }

    @Override
    public Result getAllTopicConversations() {
        return null;
    }
}
