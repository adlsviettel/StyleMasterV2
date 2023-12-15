package com.style.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetOverView {
    @Column(name = "id")
    private int id;

    @Id
    @Column(name = "StyleMasterId")
    private int styleMasterId;

    @Column(name = "StyleMasterCode")
    private String styleMasterCode;

    @Column(name = "Season")
    private String season;

    @Column(name = "Stage")
    private String stage;

    @Column(name = "OptionNo")
    private String optionNo;

    @Column(name = "TACRouteNumber")
    private String tacRouteNumber;

    @Column(name = "A1ARouteNumber")
    private String a1aRouteNumber;

    @Column(name = "ProductType")
    private String productType;

    @Column(name = "FactoryAllocation")
    private String factoryAllocation;

    @Column(name = "MerAccountName")
    private String merAccountName;

    @Column(name = "Status")
    private int status;

    @Column(name = "TotalRowNum")
    private int totalRowNum;
}
