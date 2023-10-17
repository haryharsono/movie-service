package com.haryharsono.movie.service.controller;

import com.haryharsono.movie.service.dto.webResponse;
import com.haryharsono.movie.service.exceptionHandler.NotFoundException;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorController {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<webResponse<String>> handleCustomBadRequestException(NotFoundException ex) {
        return ResponseEntity.badRequest().body(new webResponse<>(  400,
                "Bad Request",
                ex.getMessage()));
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<webResponse<String>> handleValidationException(ConstraintViolationException ex) {
      return   ResponseEntity.badRequest().body(new webResponse<>(  400,
                "Bad Request",
                ex.getMessage()));
    }

}
