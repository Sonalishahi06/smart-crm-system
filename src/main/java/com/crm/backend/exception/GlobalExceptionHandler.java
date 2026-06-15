package com.crm.backend.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>> handleValidationException(
            MethodArgumentNotValidException ex){
        Map<String,String> errors=new HashMap<>();
        ex.getBindingResult().getFieldErrors()
                .forEach(error ->
                        errors.put(
                                error.getField(),
                                error.getDefaultMessage()
                        ));
        return ResponseEntity.badRequest().body(errors);
    }

    @ExceptionHandler(EmailAlreadyExistsException.class)
    public ResponseEntity<Map<String, String>> handleEmailAlreadyExists(
            EmailAlreadyExistsException ex) {

        Map<String, String> error = new HashMap<>();

        error.put("error", ex.getMessage());

        return ResponseEntity.status(409).body(error);
    }

    @ExceptionHandler(InvalidPasswordException.class)
    public ResponseEntity<Map<String,String>>handleInvalidPassword(InvalidPasswordException ex){
        Map<String,String>error=new HashMap<>();

        error.put("error",ex.getMessage());
        return ResponseEntity.badRequest().body(error);
    }
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Map<String,String >>handleUserNotFound(UserNotFoundException ex){
        Map<String,String>error=new HashMap<>();
        error.put("error",ex.getMessage());
        return ResponseEntity.status(404).body(error);
    }

    @ExceptionHandler(InvalidCredentialsException.class)
    public ResponseEntity<Map<String,String >> handleInvalidCredentials(InvalidCredentialsException ex){
        Map<String,String>error=new HashMap<>();
        error.put("error",ex.getMessage());
        return ResponseEntity.status(401).body(error);
    }

    @ExceptionHandler(UnauthorizedLeadCreationException.class)
    public ResponseEntity<Map<String, String>> handleUnauthorizedLeadCreation(UnauthorizedLeadCreationException ex) {
        Map<String, String> error = new HashMap<>();
        error.put("error", ex.getMessage());
        return ResponseEntity.status(403).body(error);
    }

    @ExceptionHandler(LeadNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleLeadNotFound(LeadNotFoundException ex){
        Map<String, String> error = new HashMap<>();
        error.put("error", ex.getMessage());
        return ResponseEntity.status(404).body(error);
    }

    @ExceptionHandler(InvalidLeadAssignmentException.class)
    public ResponseEntity<Map<String, String>> handleInvalidAssignment(InvalidLeadAssignmentException ex) {

        Map<String, String> error = new HashMap<>();
        error.put("error", ex.getMessage());

        return ResponseEntity.status(400).body(error);
    }

    @ExceptionHandler(UnauthorizedLeadUpdateException.class)
    public ResponseEntity<Map<String, String>> handleUnauthorizedUpdate(UnauthorizedLeadUpdateException ex) {

        Map<String, String> error = new HashMap<>();
        error.put("error", ex.getMessage());

        return ResponseEntity.status(403).body(error);
    }


    @ExceptionHandler(InvalidTaskAssignmentException.class)
    public ResponseEntity<Map<String, String>> handleInvalidTaskAssignment(InvalidTaskAssignmentException ex) {

        Map<String, String> error = new HashMap<>();
        error.put("error", ex.getMessage());

        return ResponseEntity.status(400).body(error);
    }

    @ExceptionHandler(TaskNotFoundException.class)
    public ResponseEntity<Map<String,String>> handleTaskNotFound(TaskNotFoundException ex){
        Map<String,String> error=new HashMap<>();
        error.put("error",ex.getMessage());
        return ResponseEntity.status(404).body(error);
    }

    @ExceptionHandler(UnauthorizedTaskUpdateException.class)
    public ResponseEntity<Map<String, String>> handleUnauthorizedTaskUpdate(UnauthorizedTaskUpdateException ex) {
        Map<String, String> error = new HashMap<>();
        error.put("error", ex.getMessage());

        return ResponseEntity.status(403).body(error);
    }
}
