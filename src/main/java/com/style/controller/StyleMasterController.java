package com.style.controller;

import com.style.ResponseAPI;
import com.style.entity.GetOverView;
import com.style.entity.InsertStyleMaster;
import com.style.entity.SearchBodyOverView;
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

    @GetMapping
    public ResponseAPI<?> getAllStyleMaster(@RequestParam Integer pPageIndex, @RequestParam Integer pPageSize, @RequestParam String pCustomerCode) {
        return styleMasterService.getStyleMasterByPage(pPageIndex, pPageSize, pCustomerCode);
    }

    @GetMapping("/style_details")
    public ResponseAPI<?> getStyleMasterDetailByStyleMasterId(@RequestParam Integer pStyleMasterId) {
        return styleMasterService.getStyleMasterDetailByStyleMasterId(pStyleMasterId);
    }

    @GetMapping("/get_filter")
    public ResponseAPI<?> getFilterList(@RequestParam String pCustomerCode) {
        return styleMasterService.getFilterList(pCustomerCode);
    }

    @PostMapping("/insert_update_style")
    public ResponseAPI<?> insertUpdateStyleMaster(@RequestBody InsertStyleMaster jSonStyleMaster,
                                                  @RequestParam Integer pAction,
                                                  @RequestParam Integer pCreatedBy,
                                                  @RequestParam Integer pOutput) {
        return styleMasterService.insertUpdateStyleMaster(jSonStyleMaster, pAction, pCreatedBy, pOutput);
    }

    @GetMapping("/search_over_view")
    public ResponseAPI<?> searchOverView(SearchBodyOverView searchBodyOverView) {
        return styleMasterService.searchOverView(searchBodyOverView);
    }
}
