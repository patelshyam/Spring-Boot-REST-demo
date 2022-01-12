package com.springboot.blog.controller;

import com.springboot.blog.payload.CommentDto;
import com.springboot.blog.service.CommentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


/*
 * @RestController - To declare the class as a Controller class which will handle restAPI requests
 * @RequestMapping - What will be the initial path of the RESTAPI It will handle that.
 * @PostMapping("path/{param_of_path}/path") - This annotation will declare the method as a POST API and the name between {}
 * is the name of the variable that used in the code later which is known as a path variable
 * @PathVaraible(name="param_of_path") - This annotation represents the path_variable of the Mapping from where we are fetching
 * the value to process further.
 * @RequestBody - It will bind the passed variable in the body which are passed in the POST request
 * @GetMapping - GetMapping is the similar kind of function which will convert the method into Get API.
 * @RequestParam - This will be the parameter passed in the URL after ? and separated ny & sign.
 * @PutMapping - PutMapping is the similar kind of function which will convert the method into PUT API.
 * @DeleteMapping - DeleteMapping is the similar kind of function which will convert the method into Delete API.
 * - If you are injecting the service from a single implemented method then you do not need to annotate with Autowired
 *
 * @Valid - This annotation will check the rules define in particular class (check CommentDto) where the arguments are passed and after checking
 * validation it will give appropriate error or pass the validation.
 * */


@Api(value = "CRUD REST APIs for comment resource")
@RestController
@RequestMapping("/api/")
public class CommentController {

    private CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @ApiOperation(value = "Create comment REST API.")
    @PostMapping("/posts/{postId}/comments")
    public ResponseEntity<CommentDto> createComment(@PathVariable(value = "postId") long postId,
                                                    @Valid @RequestBody CommentDto commentDto){
        return new ResponseEntity<>(commentService.createComment(postId, commentDto), HttpStatus.CREATED);
    }

    @ApiOperation(value = "Get comments by PostId")
    @GetMapping("/posts/{postId}/comments")
    public List<CommentDto> getCommentsByPostId(@PathVariable(value = "postId") Long postId){
        return commentService.getCommentsByPostId(postId);
    }

    @ApiOperation(value = "Get comment by Post and Comment ID")
    @GetMapping("/posts/{postId}/comments/{id}")
    public ResponseEntity<CommentDto> getCommentById(@PathVariable(value = "postId") Long postId,
                                                     @PathVariable(value = "id") Long commentId){
        CommentDto commentDto = commentService.getCommentById(postId, commentId);
        return new ResponseEntity<>(commentDto, HttpStatus.OK);
    }

    @ApiOperation(value = "Update Comment REST API")
    @PutMapping("/posts/{postId}/comments/{id}")
    public ResponseEntity<CommentDto> updateComment(@PathVariable(value = "postId") Long postId,
                                                    @PathVariable(value = "id") Long commentId,
                                                    @Valid @RequestBody CommentDto commentDto){
        CommentDto updatedComment = commentService.updateComment(postId, commentId, commentDto);
        return new ResponseEntity<>(updatedComment, HttpStatus.OK);
    }

    @ApiOperation(value = "Delete comment REST API")
    @DeleteMapping("/posts/{postId}/comments/{id}")
    public ResponseEntity<String> deleteComment(@PathVariable(value = "postId") Long postId,
                                                @PathVariable(value = "id") Long commentId){
        commentService.deleteComment(postId, commentId);
        return new ResponseEntity<>("Comment deleted successfully", HttpStatus.OK);
    }
}
