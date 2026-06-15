package com.crm.backend.exception;

public class UnauthorizedTaskUpdateException extends RuntimeException{
    public UnauthorizedTaskUpdateException(String message) {
        super(message);
    }
}
