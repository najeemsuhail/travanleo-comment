package com.travanleo.comment.controller;

import com.travanleo.comment.CommonResponse;
import com.travanleo.comment.dto.*;
import com.travanleo.comment.model.Comment;
import com.travanleo.comment.model.User;
import com.travanleo.comment.repository.CommentRepo;
import com.travanleo.comment.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentRepo commentRepo;
@Autowired
private UserRepo userRepo;

    @GetMapping("/list")
    public CommonResponse listComment(){
        ListCommentResponse response = new ListCommentResponse();
        final List<Comment> commentList = commentRepo.findAll();
        response.setCommentList(commentList);
        return new CommonResponse(CommonResponse.SUCCESS_CODE,CommonResponse.SUCCESS, response);
    }

@PostMapping("/create")
    public CommonResponse createComment(@RequestBody final CreateCommentRequest request){
        CreateCommentResponse response = new CreateCommentResponse();
        Comment comment = new Comment();
        comment.setTitle(request.getTitle());
        comment.setContent(request.getContent());
        comment.setUser(userRepo.findById(request.getUserId()).get());
        commentRepo.save(comment);
        response.setCommentList(commentRepo.findAll());
        return new CommonResponse(CommonResponse.SUCCESS_CODE,CommonResponse.SUCCESS, response);
    }

    @PutMapping("/update")
    public CommonResponse updateComment(@RequestBody final UpdateCommentRequest request){
        UpdateCommentResponse response = new UpdateCommentResponse();
        Optional<Comment> optionalComment = commentRepo.findById(request.getCommentId());
        Comment comment = optionalComment.get();
        comment.setTitle(request.getTitle());
        comment.setContent(request.getContent());
        comment.setUser(userRepo.findById(request.getUserId()).get());
        commentRepo.save(comment);
        response.setMessage("Updated successfully");
        response.setCommentList(commentRepo.findAll());
        return new CommonResponse(CommonResponse.SUCCESS_CODE,CommonResponse.SUCCESS, response);
    }

    @DeleteMapping("/delete/{commentId}")
    public CommonResponse deleteComment(@PathVariable("commentId") Long commentId){
        DeleteCommentResponse response = new DeleteCommentResponse();
        final Optional<Comment> optionalComment = commentRepo.findById(commentId);
        commentRepo.delete(optionalComment.get());
        response.setMessage("Deleted successfully");
        return new CommonResponse(CommonResponse.SUCCESS_CODE,CommonResponse.SUCCESS, response);
    }
}
