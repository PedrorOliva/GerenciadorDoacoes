package com.catalisa.GerenciamentoDoacoes.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class handleNameNotFound extends RuntimeException{
  public handleNameNotFound(String message) {
    super(message);
  }
}
