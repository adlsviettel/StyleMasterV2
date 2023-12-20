package com.style.service;

import com.style.HeaderTableHelper;
import com.style.ResponseAPI;
import com.style.entity.*;
import com.style.model.Contents;
import com.style.model.TableResponse;
import com.style.model.TableResponseNon;
import com.style.repository.*;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger logger = LoggerFactory.getLogger(GetOverView.class);

    @Transactional(readOnly = true)
    public ResponseAPI<?> getStyleMasterByPage(Integer pageNumber, Integer pageSize, String pCustomerCode) {
        var content = styleMasterRepository.getOverview(pageNumber, pageSize, pCustomerCode);
        HeaderTableHelper<GetOverView> headerTableHelper = new HeaderTableHelper<>();
        var headers = headerTableHelper.getHeaders(new GetOverView());
        Contents contentsList = new Contents(pageNumber,
                pageSize,
                content.get(0).getTotalRowNum(),
                content.get(0).getTotalRowNum() / pageSize,
                content);
        logger.info("Get Style Master");
        for (int i = 0; i < content.size(); i++) {
            logger.info(content.get(i).toString() + "\n\n");
        }
        return new ResponseAPI<>(200, null, new TableResponse(headers, contentsList) {
        });
    }

    @Transactional(readOnly = true)
    public ResponseAPI<?> getStyleMasterDetailByStyleMasterId(Integer styleMasterId) {
        var content = styleMasterDetailRepository.getDetailByStyleMasterId(styleMasterId);
        HeaderTableHelper<StyleMasterDetail> headerTableHelper = new HeaderTableHelper<>();
        var headers = headerTableHelper.getHeaders(new StyleMasterDetail());
        return new ResponseAPI<>(200, null, new TableResponseNon(headers, content));
    }

    @Transactional(readOnly = true)
    public ResponseAPI<?> getFilterList(String pCustomerCode) {
        var content = getFilterRepository.getFilterList(pCustomerCode);
        HeaderTableHelper<GetFilter> headerTableHelper = new HeaderTableHelper<>();
        var headers = headerTableHelper.getHeaders(new GetFilter());
        return new ResponseAPI<>(200, null, new TableResponseNon(headers, content));
    }

    public ResponseAPI<?> insertUpdateStyleMaster(InsertStyleMaster pJSonStyleMaster,
                                                  Integer pAction,
                                                  Integer pCreatedBy,
                                                  Integer pOutput) {
        String xmlString = "<root>" +
                "  <row>" +
                "    <StyleMasterId>" + pJSonStyleMaster.getId() + "</StyleMasterId>" +
                "    <StyleMasterCode>" + pJSonStyleMaster.getStyleMasterCode() + "</StyleMasterCode>" +
                "    <Season>" + pJSonStyleMaster.getSeason() + "</Season>" +
                "    <Stage>" + pJSonStyleMaster.getStage() + "</Stage>" +
                "    <OptionNo>" + pJSonStyleMaster.getOptionNo() + "</OptionNo>" +
                "    <TACRouteNumber>" + pJSonStyleMaster.getTacRouteNumber() + "</TACRouteNumber>" +
                "    <A1ARouteNumber>" + pJSonStyleMaster.getA1aRouteNumber() + "</A1ARouteNumber>" +
                "    <ProductType>" + pJSonStyleMaster.getProductType() + "</ProductType>" +
                "    <FactoryAllocation>" + pJSonStyleMaster.getFactoryAllocation() + "</FactoryAllocation>" +
                "    <MerAccountName>" + pJSonStyleMaster.getMerAccountName() + "</MerAccountName>" +
                "    <Status>" + pJSonStyleMaster.getStatus() + "</Status>" +
                "    <CuttingSMV>" + pJSonStyleMaster.getCuttingSMV() + "</CuttingSMV>" +
                "    <Sewing>" + pJSonStyleMaster.getSewing() + "</Sewing>" +
                "    <Inspect>" + pJSonStyleMaster.getInspect() + "</Inspect>" +
                "    <Press>" + pJSonStyleMaster.getPress() + "</Press>" +
                "    <Finishing>" + pJSonStyleMaster.getFinishing() + "</Finishing>" +
                "    <TotalSIPFSMV>" + pJSonStyleMaster.getTotalSIPFSMV() + "</TotalSIPFSMV>" +
                "    <BondingProcess>" + pJSonStyleMaster.getBondingProcess() + "</BondingProcess>" +
                "    <HTSmall>" + pJSonStyleMaster.getHtSmall() + "</HTSmall>" +
                "    <HTTotalPosition>" + pJSonStyleMaster.getHtTotalPosition() + "</HTTotalPosition>" +
                "    <PadPrintPosition>" + pJSonStyleMaster.getPadPrintPosition() + "</PadPrintPosition>" +
                "    <PadPrintTotalSMV>" + pJSonStyleMaster.getPadPrintTotalSMV() + "</PadPrintTotalSMV>" +
                "    <ScreenPrintPosition>" + pJSonStyleMaster.getScreenPrintPosition() + "</ScreenPrintPosition>" +
                "    <ScreenPrintPrinter>" + pJSonStyleMaster.getScreenPrintPrinter() + "</ScreenPrintPrinter>" +
                "    <SublimationPrinter>" + pJSonStyleMaster.getSublimationPrinter() + "</SublimationPrinter>" +
                "  </row>" +
                "</root>";
        insertStyleMasterRepository.insertUpdateStyleMaster(xmlString, pAction, pCreatedBy, pOutput);
        return new ResponseAPI<>(200, null, "Insert Completed !");
    }

    @Transactional(readOnly = true)
    public ResponseAPI<?> searchOverView(SearchBodyOverView searchBodyOverView) {
        var content = searchOverViewRepository.searchOverView(
                searchBodyOverView.getPStyleMasterCode(),
                searchBodyOverView.getPSeason(),
                searchBodyOverView.getPStage(),
                searchBodyOverView.getPCustomerCode(),
                searchBodyOverView.getPProductType(),
                searchBodyOverView.getPFactoryAllocation(),
                searchBodyOverView.getPMerAccountName(),
                searchBodyOverView.getPFromDate(),
                searchBodyOverView.getPToDate(),
                searchBodyOverView.getPPageIndex(),
                searchBodyOverView.getPPageSize());
        HeaderTableHelper<GetOverView> headerTableHelper = new HeaderTableHelper<>();
        var headers = headerTableHelper.getHeaders(new GetOverView());
        Contents contentList = new Contents(searchBodyOverView.getPPageIndex(),
                searchBodyOverView.getPPageSize(),
                content.get(0).getTotalRowNum(),
                content.get(0).getTotalRowNum() / searchBodyOverView.getPPageSize(),
                content);
        return new ResponseAPI<>(200, null, new TableResponse(headers, contentList));
    }
}
