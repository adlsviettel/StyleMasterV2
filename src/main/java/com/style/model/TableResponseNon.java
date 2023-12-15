package com.style.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class TableResponseNon {
    private List<String> headers;
    @JsonProperty("content")
    private Object content;
}
