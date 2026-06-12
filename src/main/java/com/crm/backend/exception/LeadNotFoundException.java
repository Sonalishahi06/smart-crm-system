package com.crm.backend.exception;

public class LeadNotFoundException extends RuntimeException{
    public LeadNotFoundException(String message){
        super(message);
    }
}
