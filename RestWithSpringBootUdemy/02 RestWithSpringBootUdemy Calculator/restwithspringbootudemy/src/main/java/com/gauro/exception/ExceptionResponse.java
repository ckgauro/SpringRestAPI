package com.gauro.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Chandra
 */
@Data
@AllArgsConstructor
public class ExceptionResponse  implements Serializable {
    private static  final long serialVersionUID=1L;
    private Date timestamp;
    private String message;
    private String details;


}
