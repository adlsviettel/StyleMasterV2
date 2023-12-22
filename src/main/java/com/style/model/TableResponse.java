package com.style.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TableResponse {
    @JsonProperty(value = "headers")
    private List<String> headers;
    @JsonProperty(value = "content")
    private Contents content;
}
