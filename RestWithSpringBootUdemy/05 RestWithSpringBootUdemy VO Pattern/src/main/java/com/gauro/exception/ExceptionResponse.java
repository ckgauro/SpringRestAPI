package com.gauro.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Chandra
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExceptionResponse implements Serializable {
    private static final long serialVersionUID=1l;
    private Date timeStamp;
    private String message;
    private String details;
}
