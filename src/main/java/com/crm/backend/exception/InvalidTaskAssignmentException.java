package com.crm.backend.exception;

public class InvalidTaskAssignmentException extends RuntimeException{
    public InvalidTaskAssignmentException(String message){
        super(message);
    }
}
