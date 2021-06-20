package com.gauro.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author Chandra
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ExceptionResponse implements Serializable {

    private static final long serialVersionUID=1l;
    private LocalDateTime timeStamp;
    private String message;
    private String details;

}