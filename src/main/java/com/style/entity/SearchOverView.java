package com.style.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SearchOverView {
    @Id
    @Column(name = "StyleMasterCode")
    private String styleMasterCode;

    @Column(name = "Season")
    private String season;

    @Column(name = "ProductType")
    private String productType;


    @Column(name = "MerAccountName")
    private String merAccountName;

    @Column(name = "CreatedDate")
    private Date createdDate;

    @Column(name = "TotalRowNum")
    private int totalRowNum;
}
