package com.style.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Contents {
    private int pageIndex;
    private int rowPerPage;
    private int totalElements;
    private int totalPages;
    @JsonProperty("dataList")
    private List<?> dataList;
}
