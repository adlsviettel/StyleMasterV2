package com.style.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class TableResponse {
    private List<String> headers;
    private Contents content;
}
