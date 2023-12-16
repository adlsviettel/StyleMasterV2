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
    @Column(name = "id")
    private Integer id;

    @Column(name = "StyleMasterCode")
    private String styleMasterCode;

    @Column(name = "Season")
    private String season;

    @Column(name = "Stage")
    private String stage;

    @Column(name = "OptionNo")
    private String optionNo;

    @Column(name = "ProductType")
    private String productType;

    @Column(name = "FactoryAllocation")
    private String factoryAllocation;

    @Column(name = "MerAccountName")
    private String merAccountName;

    @Column(name = "Status")
    private Integer status;

    @Column(name = "CreatedDate")
    private Date createdDate;

    @Column(name = "TotalRowNum")
    private Integer totalRowNum;
}
