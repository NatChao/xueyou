package com.xueyouwang.xueyou.service.Impl;

import com.xueyouwang.xueyou.Bean.CommentBO;
import com.xueyouwang.xueyou.Bean.CommentBean;
import com.xueyouwang.xueyou.Bean.UserBO;
import com.xueyouwang.xueyou.dao.CommentMapper;
import com.xueyouwang.xueyou.dao.UserMapper;
import com.xueyouwang.xueyou.entity.Comment;
import com.xueyouwang.xueyou.entity.User;
import com.xueyouwang.xueyou.response.ResponseResult;
import com.xueyouwang.xueyou.service.CommentService;
import com.xueyouwang.xueyou.utlis.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentMapper commentMapper;
    @Autowired
    private UserMapper userMapper;


    @Override
    public Result insertComment(Comment comment, HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        if (user != null){
            comment.setUserId(user.getId());
            comment.setCreateTime(LocalDateTime.now());
            commentMapper.insertSelective(comment);
            return ResponseResult.genSuccessResult();
        }else {
            return ResponseResult.genFailResult("评论失败，请登录后重试。");
        }
    }

    @Override
    public Result deleteComment(Long id, HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        if (user != null){
            Comment comment = commentMapper.selectByPrimaryKey(id);
            //判断该评论如果是该用户，则可以删除成功
            if (comment.getUserId().equals(user.getId())){
                commentMapper.deleteComment(id);
                return ResponseResult.genSuccessDeleteResult();
            }
            return ResponseResult.genFailResult("您无权删除该评论");
        }else {
            return ResponseResult.genFailResult("删除失败，请登录后重试。");
        }
    }

    @Override
    public Result getTopicConversationComments(Long topicConversationId) {
        //根据话题id查询出该话题的所有评论数据
        List<Comment> topicConversationComments = commentMapper.getTopicConversationComments(topicConversationId);

        List<CommentBO> commentBOList = new ArrayList<>();
        for (Comment comment : topicConversationComments) {
            CommentBO commentBO = new CommentBO(); //创建返回评论实体类
            CommentBean originalCommentBean = new CommentBean(); //创建原评论中间类
            User user = userMapper.selectByPrimaryKey(comment.getUserId());
            originalCommentBean.setUserBO(new UserBO(user));
            //设置原评论中间类对象
            commentBO.setOriginalComments(originalCommentBean);
            if (comment.getReplyId() != null){ // 判断该原评论对象是否存在回复评论
                Comment replyComment = commentMapper.selectByPrimaryKey(comment.getReplyId());
                if (replyComment.getState() != 0){ // 判断该回复评论是否已被删除
                    User replyUser = userMapper.selectByPrimaryKey(replyComment.getUserId());
                    CommentBean replyCommentBean = new CommentBean();
                    replyCommentBean.setUserBO(new UserBO(replyUser));
                    //设置回复评论中间类
                    commentBO.setReplyComments(replyCommentBean);
                }
            }
            commentBOList.add(commentBO);
        }
        return ResponseResult.genSuccessResult(commentBOList);
    }

}
