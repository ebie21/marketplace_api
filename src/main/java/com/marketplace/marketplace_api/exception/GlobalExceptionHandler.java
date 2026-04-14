package com.marketplace.marketplace_api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

   @ExceptionHandler(ResourceNotFoundException.class)
   public ResponseEntity<Map<String,Object>> handleResourceNotFoundException(ResourceNotFoundException ex){
       Map<String,Object> map = new HashMap<>();
       map.put("timestamp", java.time.LocalDateTime.now());
       map.put("message", ex.getMessage());
       return new ResponseEntity<>(map,HttpStatus.NOT_FOUND);
   }

    //this if for database errors Internal server
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String,Object>> handleException(Exception ex){
        Map<String,Object> map = new HashMap<>();
        map.put("timestamp", java.time.LocalDateTime.now());
        map.put("message",ex.getMessage());
        map.put("status",HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(InvalidProductException.class)
    public ResponseEntity<Map<String,Object>> handleInvalidProductException(InvalidProductException ex){
        Map<String,Object> map = new HashMap<>();
        map.put("timestamp", java.time.LocalDateTime.now());
        map.put("message",ex.getMessage());
        map.put("status",HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UnauthorizedAccessException.class)
    public ResponseEntity<Map<String,Object>> handleUnauthorizedAccessException(UnauthorizedAccessException ex){
        Map<String,Object> map = new HashMap<>();
        map.put("timestamp", java.time.LocalDateTime.now());
        map.put("message",ex.getMessage());
        map.put("status",HttpStatus.UNAUTHORIZED);
        return new ResponseEntity<>(map, HttpStatus.UNAUTHORIZED);
    }
}
