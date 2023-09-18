package com.catalisa.GerenciamentoDoacoes.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@ControllerAdvice
public class CustonExceptionHandler extends ResponseEntityExceptionHandler {
  @org.springframework.web.bind.annotation.ExceptionHandler(handleIdNotFound.class)
  public ResponseEntity<Object> handleIdNotFound(handleIdNotFound e) {
    Map<String, Object> body = new LinkedHashMap<>();
    body.put("timestamp", new Date());
    body.put("message", e.getMessage());

    return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
  }

  @org.springframework.web.bind.annotation.ExceptionHandler(handleNameNotFound.class)
  public ResponseEntity<Object> handleNameNotFound(handleNameNotFound e) {
    Map<String, Object> body = new HashMap<>();
    body.put("timestamp", new Date());
    body.put("message", e.getMessage());

    return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
  }
}
