package com.springboot.blog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


/*
 * PART OF LOMBOK ANNOTATIONS:-
 *
 * @Data - This annotation is used for auto implementation of the Getter, Setter, toString methods and much more.
 * @AllArgsConstructor:- This will create the constructor of all arguments which will create the all argument constructor.
 * @NoArgsConstructor:- This will create the constructor of No arguments.
 *
 * PART OF JPA ANNOTATIONS:-
 *
 * @Entity:- This annotation will create the class as an entity in the project, which will be synced to the database in the background.
 * @Table(name="comments") - This annotation will create the table which is synced with this class.
 * @Id - this annotation define the primary key of that particular variable.
 * @GeneratedValue - It will declare the strategy to declare the primary key.
 * @ManyToOne - It will create the relation of ManyToOne for the join class.
 * @JoinColumn(name="post_id",nullable = false) - It will create the primary key joined name as post_id
 */


@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String email;
    private String body;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id", nullable = false)
    private Post post;
}
