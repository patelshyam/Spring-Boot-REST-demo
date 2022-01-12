package com.springboot.blog.repository;

import com.springboot.blog.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// JpaRepository is used to connect the Entity class to Operation for the database
// You can add @Repository annotation at this point but the JpaRepository is already annotated, so you do not need to.

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByPostId(long postId);
}
