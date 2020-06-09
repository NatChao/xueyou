package com.xueyouwang.xueyou.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Comment implements Serializable {
    private Long id;

    private Long topicConversationId;

    private Long userId;

    private String content;

    private Integer giveLike;

    private LocalDateTime createTime;

    private Integer state;

    private Long replyId;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTopicConversationId() {
        return topicConversationId;
    }

    public void setTopicConversationId(Long topicConversationId) {
        this.topicConversationId = topicConversationId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Integer getGiveLike() {
        return giveLike;
    }

    public void setGiveLike(Integer giveLike) {
        this.giveLike = giveLike;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Long getReplyId() {
        return replyId;
    }

    public void setReplyId(Long replyId) {
        this.replyId = replyId;
    }
}