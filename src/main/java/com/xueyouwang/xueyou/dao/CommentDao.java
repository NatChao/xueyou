package com.xueyouwang.xueyou.dao;

import com.xueyouwang.xueyou.entity.Comment;
import java.util.List;

public interface CommentDao {

    int insertComment(Comment comment);

    int deleteComment(Long id);

    List<Comment> getTopicConversationComments(Long topicConversationId);

    Comment selectComment(Long id);
}
