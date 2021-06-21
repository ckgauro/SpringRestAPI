package com.gauro.data.vo.v1;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.github.dozermapper.core.Mapping;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Chandra
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonPropertyOrder
public class BookVO  extends RepresentationModel<BookVO> implements Serializable {
    private static final long serialVersionUID=1l;

    @Mapping("id")
    @JsonProperty("id")
    private Long id;
    private String author;

    private Date launchData;
    private Double price;
    private String title;



}
