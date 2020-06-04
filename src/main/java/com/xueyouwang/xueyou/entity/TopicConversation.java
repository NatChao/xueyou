package com.xueyouwang.xueyou.entity;

import java.time.LocalDateTime;

//话题
public class TopicConversation {

    private Long id;
    private Long userId;
    private String title;
    private String themePicture;
    private LocalDateTime createTime;
    private int views;

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
        this.title = title;
    }

    public String getThemePicture() {
        return themePicture;
    }

    public void setThemePicture(String themePicture) {
        this.themePicture = themePicture;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }
}
