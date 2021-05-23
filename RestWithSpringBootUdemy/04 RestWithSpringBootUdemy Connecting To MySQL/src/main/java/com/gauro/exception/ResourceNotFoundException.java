package com.gauro.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Chandra
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException  extends RuntimeException{

    private  static final long serialVersionUID = 1L;

    public ResourceNotFoundException(String exception) {
        super(exception);
    }
}