package com.xueyouwang.xueyou.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

public class TopicConversation implements Serializable {
    private Long id;

    private Long userId;

    private String title;

    private String themePicture;

    private LocalDateTime createTime;

    private Integer views;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getThemePicture() {
        return themePicture;
    }

    public void setThemePicture(String themePicture) {
        this.themePicture = themePicture == null ? null : themePicture.trim();
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }
}