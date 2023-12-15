package com.style.exceptions;

import com.style.ResponseAPI;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.net.http.HttpConnectTimeoutException;
import java.net.http.HttpTimeoutException;

@RestControllerAdvice
@Slf4j
public class GlobalException {
    @ExceptionHandler({Exception.class})
    public ResponseEntity<ResponseAPI<Object>> handleException(Exception ex) {
        log.error("Clause : {} and message {}", ex.getClass().getName(), ex.getMessage());
        var response = new ResponseAPI<>(400, "Unknown", null);
        return ResponseEntity.status(400).body(response);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ResponseAPI<Object>> handleHttpMessageNotReadableException(
            HttpMessageNotReadableException ex
    ) {
        var response = new ResponseAPI<>(HttpStatus.BAD_REQUEST.value(), ex.getMessage(), null);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(HttpMediaTypeException.class)
    public ResponseEntity<ResponseAPI<Object>> handleHttpMediaTypeException(HttpMediaTypeException ex) {
        var response = new ResponseAPI<>(HttpStatus.UNSUPPORTED_MEDIA_TYPE.value(), ex.getMessage(), null);
        return ResponseEntity.status(HttpStatus.UNSUPPORTED_MEDIA_TYPE).body(response);
    }

    @ExceptionHandler(HttpTimeoutException.class)
    public ResponseEntity<ResponseAPI<Object>> handleHttpTimeoutException(HttpTimeoutException ex) {
        var response = new ResponseAPI<>(HttpStatus.REQUEST_TIMEOUT.value(), ex.getMessage(), null);
        return ResponseEntity.status(408).body(response);
    }

    @ExceptionHandler(HttpServerErrorException.class)
    public ResponseEntity<ResponseAPI<Object>> handleHttpServerErrorException(HttpServerErrorException ex) {
        var response = new ResponseAPI<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage(), null);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }

    @ExceptionHandler(HttpConnectTimeoutException.class)
    public ResponseEntity<ResponseAPI<Object>> handleHttpConnectTimeoutException(HttpConnectTimeoutException ex) {
        var response = new ResponseAPI<>(HttpStatus.REQUEST_TIMEOUT.value(), ex.getMessage(), null);
        return ResponseEntity.status(HttpStatus.REQUEST_TIMEOUT).body(response);
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<ResponseAPI<Object>> handleHttpRequestMethodNotSupportedException(
            HttpRequestMethodNotSupportedException ex
    ) {
        var response = new ResponseAPI<>(HttpStatus.METHOD_NOT_ALLOWED.value(), ex.getMessage(), null);
        return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body(response);
    }

    @ExceptionHandler(HttpClientErrorException.class)
    public ResponseEntity<ResponseAPI<Object>> handleHttpClientErrorException(HttpClientErrorException ex) {
        var response = new ResponseAPI<>(HttpStatus.NOT_FOUND.value(), ex.getMessage(), null);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ResponseAPI<Object>> handleRunTimeException(RuntimeException ex) {
        var response = new ResponseAPI<>(HttpStatus.BAD_REQUEST.value(), ex.getMessage(), null);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<ResponseAPI<Object>> handleRunTimeException(NoHandlerFoundException ex) {
        var response = new ResponseAPI<>(HttpStatus.NOT_FOUND.value(), ex.getMessage(), null);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
}
