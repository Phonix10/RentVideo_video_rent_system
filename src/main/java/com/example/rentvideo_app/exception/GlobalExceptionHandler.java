package com.example.rentvideo_app.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;



@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{


    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Object> handleRuntimeException(RuntimeException ex, WebRequest request) {
        
        if (ex.getMessage().contains("not found") || ex.getMessage().contains("already exists")) {
            System.err.println("Handling RuntimeException: " + ex.getMessage());
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND); 
        }
        return new ResponseEntity<>("An unexpected error occurred: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
}
