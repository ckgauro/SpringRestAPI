package com.gauro.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Chandra
 */
@Data
@AllArgsConstructor
@Builder
public class Greeting {
    private final long id;
    private final String content;
}
