package com.gauro.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Chandra
 */

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UnsupportedMathOperationException extends  RuntimeException{
    private static final long serialVersionUID=1L;
    public UnsupportedMathOperationException(String exception){
        super(exception);
    }


}
