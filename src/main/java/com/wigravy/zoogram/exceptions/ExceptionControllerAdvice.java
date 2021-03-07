package com.wigravy.zoogram.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionControllerAdvice {
    @ExceptionHandler(UsernameNotFoundException.class)
    public ResponseEntity<Object> UsernameNotFoundExceptionHandler(UsernameNotFoundException ex) {
        return new ResponseEntity<>(new UsernameNotFoundException(ex.getMessage()), HttpStatus.NOT_FOUND);
    }
}
