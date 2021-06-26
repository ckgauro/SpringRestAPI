package com.gauro.data.vo.v1;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.github.dozermapper.core.Mapping;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

import org.springframework.hateoas.RepresentationModel;
/**
 * @author Chandra
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonPropertyOrder({"id","address","first_name","last_name","gender"})
public class PersonVO extends RepresentationModel<PersonVO> implements Serializable {

    private static final long serialVersionUID=1l;

    @Mapping
    @JsonProperty("id")
    private Long id;
    //@JsonProperty("first_name")
    private String firstName;

    //@JsonProperty("last_name")
    private String lastName;

    private String address;
    //@JsonIgnore
    private String gender;

}