package com.style.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetFilter {
    @Id
    @Column(name = "Id")
    private Integer id;

    @Column(name = "ColumnName")
    private String columnName;

    @Column(name = "Value")
    private String value;
}
