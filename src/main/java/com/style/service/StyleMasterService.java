package com.style.service;

import com.style.ResponseAPI;
import com.style.entity.InsertStyleMaster;
import com.style.model.Contents;
import com.style.model.TableResponse;
import com.style.model.TableResponseNon;
import com.style.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;

@Service
@RequiredArgsConstructor
public class StyleMasterService {
    private final StyleMasterRepository styleMasterRepository;
    private final StyleMasterDetailRepository styleMasterDetailRepository;
    private final GetFilterRepository getFilterRepository;
    private final InsertStyleMasterRepository insertStyleMasterRepository;
    private final SearchOverViewRepository searchOverViewRepository;

    @Transactional(readOnly = true)
    public ResponseAPI<?> getStyleMasterByPage(Integer pageNumber, Integer pageSize) {
        var content = styleMasterRepository.getOverview(pageNumber, pageSize);
        var headers = Arrays.asList(
                "id",
                "styleMasterId",
                "styleMasterCode",
                "season",
                "stage",
                "optionNo",
                "tacRouteNumber",
                "a1aRouteNumber",
                "productType",
                "factoryAllocation",
                "merAccountName",
                "status",
                "totalRowNum");
        Contents contentsList = new Contents(pageNumber,
                pageSize,
                content.get(0).getTotalRowNum(),
                content.get(0).getTotalRowNum() / pageSize,
                content);

        return new ResponseAPI<>(200, null, new TableResponse(headers, contentsList) {
        });
    }

    @Transactional(readOnly = true)
    public ResponseAPI<?> getStyleMasterDetailByStyleMasterId(Integer styleMasterId) {
        var content = styleMasterDetailRepository.getDetailByStyleMasterId(styleMasterId);
        var headers = Arrays.asList(
                "styleMasterId",
                "styleMasterCode",
                "season",
                "stage",
                "optionNo",
                "customerPatternCode",
                "tacRouteNumber",
                "a1aRouteNumber",
                "productType",
                "factoryAllocation",
                "merAccountName",
                "status",
                "cuttingSMV",
                "sewing",
                "inspect",
                "press",
                "finishing",
                "totalSIPFSMV",
                "bondingProcess",
                "bondingPosition",
                "bondingTotalSMV",
                "laserPosition",
                "laserTotalSMV",
                "totalBondingSMV",
                "htSmall",
                "htBig",
                "htTotalPosition",
                "htEmbroideryBacking",
                "embPosition",
                "embBadgeLogo",
                "embTotalStitch",
                "embTotalSMV",
                "padPrintPosition",
                "padPrintTotalSMV",
                "screenPrintPosition",
                "screenPrintPrinter",
                "sublimationPosition",
                "sublimationPrinter",
                "bondingItem",
                "screenPrintItem",
                "screenSublimationItem"
        );
        return new ResponseAPI<>(200, null, new TableResponseNon(headers, content));
    }

    @Transactional(readOnly = true)
    public ResponseAPI<?> getFilterList() {
        var content = getFilterRepository.getFilterList();
        var headers = Arrays.asList("id", "columnName", "value");
        return new ResponseAPI<>(200, null, new TableResponseNon(headers, content));
    }

    public ResponseAPI<?> insertUpdateStyleMaster(InsertStyleMaster pJSonStyleMaster,
                                                  Integer pAction,
                                                  Integer pCreatedBy,
                                                  Integer pOutput) {
        InsertStyleMaster styleMaster = new InsertStyleMaster();
        styleMaster.setId(pJSonStyleMaster.getId());
        styleMaster.setStyleMasterCode(pJSonStyleMaster.getStyleMasterCode());
        styleMaster.setStage(pJSonStyleMaster.getStage());
        styleMaster.setOptionNo(pJSonStyleMaster.getOptionNo());
        styleMaster.setTacRouteNumber(pJSonStyleMaster.getTacRouteNumber());
        styleMaster.setA1aRouteNumber(pJSonStyleMaster.getA1aRouteNumber());
        styleMaster.setProductType(pJSonStyleMaster.getProductType());
        styleMaster.setFactoryAllocation(pJSonStyleMaster.getFactoryAllocation());
        styleMaster.setMerAccountName(pJSonStyleMaster.getMerAccountName());
        styleMaster.setStatus(pJSonStyleMaster.getStatus());
        styleMaster.setCuttingSMV(pJSonStyleMaster.getCuttingSMV());
        styleMaster.setSewing(pJSonStyleMaster.getSewing());
        styleMaster.setInspect(pJSonStyleMaster.getInspect());
        styleMaster.setPress(pJSonStyleMaster.getPress());
        styleMaster.setFinishing(pJSonStyleMaster.getFinishing());
        styleMaster.setTotalSIPFSMV(pJSonStyleMaster.getTotalSIPFSMV());
        styleMaster.setBondingProcess(pJSonStyleMaster.getBondingProcess());
        styleMaster.setHtSmall(pJSonStyleMaster.getHtSmall());
        styleMaster.setHtTotalPosition(pJSonStyleMaster.getHtTotalPosition());
        styleMaster.setPadPrintPosition(pJSonStyleMaster.getPadPrintPosition());
        styleMaster.setPadPrintTotalSMV(pJSonStyleMaster.getPadPrintTotalSMV());
        styleMaster.setScreenPrintPosition(pJSonStyleMaster.getScreenPrintPosition());
        styleMaster.setScreenPrintPrinter(pJSonStyleMaster.getScreenPrintPrinter());
        styleMaster.setSublimationPrinter(pJSonStyleMaster.getSublimationPrinter());

        String xmlString = "<root>" +
                "  <row>" +
                "    <StyleMasterId>" + styleMaster.getId() + "</StyleMasterId>" +
                "    <StyleMasterCode>" + styleMaster.getStyleMasterCode() + "</StyleMasterCode>" +
                "    <Season>" + styleMaster.getSeason() + "</Season>" +
                "    <Stage>" + styleMaster.getStage() + "</Stage>" +
                "    <OptionNo>" + styleMaster.getOptionNo() + "</OptionNo>" +
                "    <TACRouteNumber>" + styleMaster.getTacRouteNumber() + "</TACRouteNumber>" +
                "    <A1ARouteNumber>" + styleMaster.getA1aRouteNumber() + "</A1ARouteNumber>" +
                "    <ProductType>" + styleMaster.getProductType() + "</ProductType>" +
                "    <FactoryAllocation>" + styleMaster.getFactoryAllocation() + "</FactoryAllocation>" +
                "    <MerAccountName>" + styleMaster.getMerAccountName() + "</MerAccountName>" +
                "    <Status>" + styleMaster.getStatus() + "</Status>" +
                "    <CuttingSMV>" + styleMaster.getCuttingSMV() + "</CuttingSMV>" +
                "    <Sewing>" + styleMaster.getSewing() + "</Sewing>" +
                "    <Inspect>" + styleMaster.getInspect() + "</Inspect>" +
                "    <Press>" + styleMaster.getPress() + "</Press>" +
                "    <Finishing>" + styleMaster.getFinishing() + "</Finishing>" +
                "    <TotalSIPFSMV>" + styleMaster.getTotalSIPFSMV() + "</TotalSIPFSMV>" +
                "    <BondingProcess>" + styleMaster.getBondingProcess() + "</BondingProcess>" +
                "    <HTSmall>" + styleMaster.getHtSmall() + "</HTSmall>" +
                "    <HTTotalPosition>" + styleMaster.getHtTotalPosition() + "</HTTotalPosition>" +
                "    <PadPrintPosition>" + styleMaster.getPadPrintPosition() + "</PadPrintPosition>" +
                "    <PadPrintTotalSMV>" + styleMaster.getPadPrintTotalSMV() + "</PadPrintTotalSMV>" +
                "    <ScreenPrintPosition>" + styleMaster.getScreenPrintPosition() + "</ScreenPrintPosition>" +
                "    <ScreenPrintPrinter>" + styleMaster.getScreenPrintPrinter() + "</ScreenPrintPrinter>" +
                "    <SublimationPrinter>" + styleMaster.getSublimationPrinter() + "</SublimationPrinter>" +
                "  </row>" +
                "</root>";
        insertStyleMasterRepository.insertUpdateStyleMaster(xmlString, pAction, pCreatedBy, pOutput);
        return new ResponseAPI<>(200, null, "Insert Completed !");
    }

    @Transactional(readOnly = true)
    public ResponseAPI<?> searchOverView(String pStyleMasterCode,
                                         String pSeason,
                                         String pProductType,
                                         String pMerAccountName,
                                         String pFromDate,
                                         String pToDate,
                                         Integer pPageIndex,
                                         Integer pPageSize) {
        var content = searchOverViewRepository.searchOverView(pStyleMasterCode, pSeason, pProductType, pMerAccountName, pFromDate, pToDate, pPageIndex, pPageSize);
        var headers = Arrays.asList("styleMasterCode", "season", "productType", "merAccountName", "createdDate");
        Contents contentList = new Contents(pPageIndex,
                pPageSize,
                content.get(0).getTotalRowNum(),
                content.get(0).getTotalRowNum() / pPageSize,
                content);
        return new ResponseAPI<>(200, null, new TableResponseNon(headers, content));
    }
}
