package com.crm.backend.exception;

public class UnauthorizedLeadUpdateException extends RuntimeException{
    public UnauthorizedLeadUpdateException(String message) {
        super(message);
    }
}
