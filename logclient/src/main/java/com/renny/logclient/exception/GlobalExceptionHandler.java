package com.renny.logclient.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.AbstractMap;

@Component
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Global Exception handler for all exceptions.
     */
    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<AbstractMap.SimpleEntry<String, String>> internalServerError(Exception exception) {
        AbstractMap.SimpleEntry<String, String> response =
                new AbstractMap.SimpleEntry<>("message", "Internal server error");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }
}



