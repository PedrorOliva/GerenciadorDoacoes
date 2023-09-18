package com.catalisa.GerenciamentoDoacoes.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class handleIdNotFound extends RuntimeException{
  public handleIdNotFound(String message) {
    super(message);
  }
}
