package com.crm.backend.exception;

public class UnauthorizedLeadCreationException extends RuntimeException{
    public UnauthorizedLeadCreationException(String message){
        super(message);
    }
}
