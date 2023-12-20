package com.style.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SearchBodyOverView {
    @Id
    private String pStyleMasterCode;
    private String pSeason;
    private String pStage;
    private String pCustomerCode;
    private String pProductType;
    private String pFactoryAllocation;
    private String pMerAccountName;
    private String pFromDate;
    private String pToDate;
    private Integer pPageIndex;
    private Integer pPageSize;
}
