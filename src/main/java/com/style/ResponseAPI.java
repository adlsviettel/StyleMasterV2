package com.style;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class ResponseAPI<T> {
    private int code;
    private String message;
    private T data;
}
