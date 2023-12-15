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
public class StyleMasterDetail {
    @Id
    @Column(name = "StyleMasterId")
    private Integer styleMasterId;

    @Column(name = "StyleMasterCode")
    private String styleMasterCode;

    @Column(name = "Season")
    private String season;

    @Column(name = "Stage")
    private String stage;

    @Column(name = "OptionNo")
    private String optionNo;

    @Column(name = "CustomerPatternCode")
    private String customerPatternCode;

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
    private String status;

    @Column(name = "CuttingSMV")
    private Float cuttingSMV;

    @Column(name = "Sewing")
    private Float sewing;

    @Column(name = "Inspect")
    private Float inspect;

    @Column(name = "Press")
    private Float press;

    @Column(name = "Finishing")
    private Float finishing;

    @Column(name = "TotalSIPFSMV")
    private Float totalSIPFSMV;

    @Column(name = "BondingProcess")
    private String bondingProcess;

    @Column(name = "BondingPosition")
    private Integer bondingPosition;

    @Column(name = "BondingTotalSMV")
    private Integer bondingTotalSMV;

    @Column(name = "LaserPosition")
    private Integer laserPosition;

    @Column(name = "LaserTotalSMV")
    private Integer laserTotalSMV;

    @Column(name = "TotalBondingSMV")
    private Integer totalBondingSMV;

    @Column(name = "HTSmall")
    private Integer htSmall;

    @Column(name = "HTBig")
    private Integer htBig;

    @Column(name = "HTTotalPosition")
    private Integer htTotalPosition;

    @Column(name = "HTEmbroideryBacking")
    private Integer htEmbroideryBacking;

    @Column(name = "EMBPosition")
    private Integer embPosition;

    @Column(name = "EMBBadgeLogo")
    private Integer embBadgeLogo;

    @Column(name = "EMBTotalStitch")
    private Integer embTotalStitch;

    @Column(name = "EMBTotalSMV")
    private Integer embTotalSMV;

    @Column(name = "PadPrintPosition")
    private Integer padPrintPosition;

    @Column(name = "PadPrintTotalSMV")
    private Float padPrintTotalSMV;

    @Column(name = "ScreenPrintPosition")
    private Integer screenPrintPosition;

    @Column(name = "ScreenPrintPrinter")
    private String screenPrintPrinter;

    @Column(name = "SublimationPosition")
    private Integer sublimationPosition;

    @Column(name = "SublimationPrinter")
    private String sublimationPrinter;

    @Column(name = "BondingItem")
    private String bondingItem;

    @Column(name = "ScreenPrintItem")
    private String screenPrintItem;

    @Column(name = "ScreenSublimationItem")
    private String screenSublimationItem;
}
