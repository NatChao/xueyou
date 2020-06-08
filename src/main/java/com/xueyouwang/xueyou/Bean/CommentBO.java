package com.xueyouwang.xueyou.Bean;

//评论返回前端实体类
public class CommentBO {
    //原评论
    private CommentBean originalComments;
    // 回复评论
    private CommentBean replyComments;
    //评论拥有者
    private boolean realyReviewers;

    public CommentBean getOriginalComments() {
        return originalComments;
    }

    public void setOriginalComments(CommentBean originalComments) {
        this.originalComments = originalComments;
    }

    public CommentBean getReplyComments() {
        return replyComments;
    }

    public void setReplyComments(CommentBean replyComments) {
        this.replyComments = replyComments;
    }

    public boolean isRealyReviewers() {
        return realyReviewers;
    }

    public void setRealyReviewers(boolean realyReviewers) {
        this.realyReviewers = realyReviewers;
    }
}
