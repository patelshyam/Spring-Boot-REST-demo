package com.springboot.blog.payload;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/*
In many cases the data we want to return could be much diffrent from the data we actully processing as an entity for that
DTO class will be created which will manage that dependency.
*/

@Data
public class CommentDto {
    private long id;
    // name should not be null or empty
    @NotEmpty(message = "Name should not be null or empty")
    private String name;

    // email should not be null or empty
    // email field validation
    @NotEmpty(message = "Email should not be null or empty")
    @Email
    private String email;

    // comment body should not be bull or empty
    // Comment body must be minimum 10 characters
    @NotEmpty
    @Size(min = 10, message = "Comment body must be minimum 10 characters")
    private String body;
}
