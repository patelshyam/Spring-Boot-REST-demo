package com.springboot.blog.payload;

import java.util.Date;
/*
In many cases the data we want to return could be much diffrent from the data we actully processing as an entity for that
DTO class will be created which will manage that dependency.
*/

public class ErrorDetails {
    private Date timestamp;
    private String message;
    private String details;

    public ErrorDetails(Date timestamp, String message, String details) {
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    public String getDetails() {
        return details;
    }
}
