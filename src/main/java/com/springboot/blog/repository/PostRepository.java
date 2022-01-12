package com.springboot.blog.repository;

import com.springboot.blog.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

// You can add @Repository annotation at this point but the JpaRepository is already annotated, so you do not need to.

public interface PostRepository extends JpaRepository<Post, Long> {

}
