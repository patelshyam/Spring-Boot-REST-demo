package com.springboot.blog.service;

import com.springboot.blog.payload.CommentDto;

import java.util.List;

/*
We are creating interface here because directly implementing the method will not give flexibility if we want to later change
the defination of the implementation. So we are creating interface here and implementing the interface in the seprate class.
*/

public interface CommentService {
    CommentDto createComment(long postId, CommentDto commentDto);

    List<CommentDto> getCommentsByPostId(long postId);

    CommentDto getCommentById(Long postId, Long commentId);

    CommentDto updateComment(Long postId, long commentId, CommentDto commentRequest);

    void deleteComment(Long postId, Long commentId);
}
