package com.style.controller;

import com.style.ResponseAPI;
import com.style.entity.GetOverView;
import com.style.entity.InsertStyleMaster;
import com.style.service.StyleMasterService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/style_master")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class StyleMasterController {
    private final StyleMasterService styleMasterService;
    private static final Logger logger = LoggerFactory.getLogger(GetOverView.class);

    @GetMapping
    public ResponseAPI<?> getAllStyleMaster(@RequestParam int pPageIndex, @RequestParam int pPageSize) {
        logger.info("Get All StyleMaster");
        return styleMasterService.getStyleMasterByPage(pPageIndex, pPageSize);
    }

    @GetMapping("/style_details")
    public ResponseAPI<?> getStyleMasterDetailByStyleMasterId(@RequestParam Integer pStyleMasterId) {
        logger.info("Get StyleMaster Details");
        return styleMasterService.getStyleMasterDetailByStyleMasterId(pStyleMasterId);
    }

    @GetMapping("/get_filter")
    public ResponseAPI<?> getFilterList() {
        logger.info("Get Filter List");
        return styleMasterService.getFilterList();
    }

    @PostMapping("/insert_update_style")
    public ResponseAPI<?> insertUpdateStyleMaster(@RequestBody InsertStyleMaster jSonStyleMaster,
                                                  @RequestParam Integer pAction,
                                                  @RequestParam Integer pCreatedBy,
                                                  @RequestParam Integer pOutput) {
        logger.info("Config StyleMaster !!!!!");
        logger.info(jSonStyleMaster.toString());
        return styleMasterService.insertUpdateStyleMaster(jSonStyleMaster, pAction, pCreatedBy, pOutput);
    }

    @GetMapping("/search_over_view")
    public ResponseAPI<?> searchOverView(@RequestParam String pStyleMasterCode,
                                         @RequestParam String pSeason,
                                         @RequestParam String pProductType,
                                         @RequestParam String pMerAccountName,
                                         @RequestParam String pFromDate,
                                         @RequestParam String pToDate,
                                         @RequestParam Integer pPageIndex,
                                         @RequestParam Integer pPageSize) {
        logger.info("Search Over View");
        return styleMasterService.searchOverView(pStyleMasterCode, pSeason, pProductType, pMerAccountName, pFromDate, pToDate, pPageIndex, pPageSize);
    }
}
