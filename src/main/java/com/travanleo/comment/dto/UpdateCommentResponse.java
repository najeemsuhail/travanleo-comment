package com.travanleo.comment.dto;

import com.travanleo.comment.model.Comment;

import java.util.List;

public class UpdateCommentResponse {
    private String message;
    private List<Comment> commentList;

    public List<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
