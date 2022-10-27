package com.reactivespring.domain;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Builder
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Document
public class ContainerDTO implements Serializable {
    @Id
    @JsonProperty("id")
    private String id;
    @JsonProperty("source")
    private String source;
    @JsonProperty("noOfContainers")
    private double noOfContainers;
    @JsonProperty("containerType")
    private String containerType;


}


