package com.style.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@NamedStoredProcedureQuery(name = "sm.usp_StyleMaster_InsertUpdate",
        procedureName = "sm.usp_StyleMaster_InsertUpdate",
        parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "pJSONStyleMaster", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "pAction", type = Integer.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "pCreatedBy", type = Integer.class),
                @StoredProcedureParameter(mode = ParameterMode.OUT, name = "pOutput", type = Integer.class)
        })
public class InsertStyleMaster {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "StyleMasterId")
    private Integer id;

    @Column(name = "StyleMasterCode")
    private String styleMasterCode;

    @Column(name = "Season")
    private String season;

    @Column(name = "Stage")
    private String stage;

    @Column(name = "OptionNo")
    private String optionNo;

    @Column(name = "TACRouteNumber")
    private String tacRouteNumber = null;

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
    private float cuttingSMV;

    @Column(name = "Sewing")
    private float sewing;

    @Column(name = "Inspect")
    private float inspect;

    @Column(name = "Press")
    private float press;

    @Column(name = "Finishing")
    private float finishing;

    @Column(name = "TotalSIPFSMV")
    private float totalSIPFSMV;

    @Column(name = "BondingProcess")
    private String bondingProcess;

    @Column(name = "HTSmall")
    private Integer htSmall;

    @Column(name = "HTTotalPosition")
    private Integer htTotalPosition;

    @Column(name = "PadPrintPosition")
    private Integer padPrintPosition;

    @Column(name = "PadPrintTotalSMV")
    private float PadPrintTotalSMV;

    @Column(name = "ScreenPrintPosition")
    private Integer screenPrintPosition;

    @Column(name = "ScreenPrintPrinter")
    private String screenPrintPrinter;

    @Column(name = "SublimationPrinter")
    private String sublimationPrinter;
}
