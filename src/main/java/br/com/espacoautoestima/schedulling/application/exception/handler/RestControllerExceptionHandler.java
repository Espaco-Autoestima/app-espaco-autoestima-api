package br.com.espacoautoestima.schedulling.application.exception.handler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestControllerExceptionHandler {

    @ExceptionHandler
    ResponseEntity<Object> internalServerErrorHandleException(Exception e) {
        return ResponseEntity.internalServerError().body(e.getMessage());
    }

    @ExceptionHandler
    ResponseEntity<Object> badRequestHandleException(Exception e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    @ExceptionHandler
    ResponseEntity<Object> notFoundHandleException(Exception e) {
        return ResponseEntity.notFound().build();
    }
}
