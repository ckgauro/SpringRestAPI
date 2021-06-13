package com.gauro.data.model.vo.v1;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Chandra
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PersonVO implements Serializable {

    private static final long serialVersionUID=1l;

    private Long id;
    private String firstName;
    private String lastName;
    private String address;
    private String gender;

}
