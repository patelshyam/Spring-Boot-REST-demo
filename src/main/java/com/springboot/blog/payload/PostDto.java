package com.springboot.blog.payload;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Set;

/*
In many cases the data we want to return could be much diffrent from the data we actully processing as an entity for that
DTO class will be created which will manage that dependency.

LOMBOK ANNOTATION
@Data - For getter, setter and toString methods.

VALIDATION ANNOTATION
-When the passed argument is having @valid annotation then the trigger will be generated for the given annotation.

@NotEmpty - this annotation will check the given field should not be empty or white spaced.
@Size(min=2,message="") - this annotation will check if the given field is having at lest two chars.

*/

@ApiModel(description = "Post model Information")
@Data
public class PostDto {
    @ApiModelProperty(value = "Blog post model ID")
    private long id;

    // title should not be null  or empty
    // title should have at least 2 characters
    @ApiModelProperty(value = "Blog post model Title")
    @NotEmpty
    @Size(min = 2, message = "Post title should have at least 2 characters")
    private String title;

    // post description should be not null or empty
    // post description should have at least 10 characters
    @ApiModelProperty(value = "Blog post description")
    @NotEmpty
    @Size(min = 10, message = "Post description should have at least 10 characters")
    private String description;

    // post content should not be null or empty
    @ApiModelProperty(value = "Blog post content for the model")
    @NotEmpty
    private String content;
    private Set<CommentDto> comments;
}
