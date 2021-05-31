package com.ruoyi.report.controller;

import com.alibaba.fastjson.JSONObject;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.report.domain.dto.AnalysisSubTableConverter;
import com.ruoyi.report.domain.dto.AnalysisSubTableData;
import com.ruoyi.report.domain.dto.DailyTableData;
import com.ruoyi.report.service.IAnalysisDataService;
import com.ruoyi.report.service.IAssembleDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/**
 * @author wzh
 */
@RestController
@RequestMapping("/report/analysisData")
public class AnalysisDataController extends BaseController {

    @Autowired
    private IAnalysisDataService analysisDataService;

    @PreAuthorize("@ss.hasPermi('report:dayreport:list')")
    @GetMapping("/get")
    public AnalysisSubTableConverter get(@RequestParam long mainTableId, @RequestParam long subTableId, @RequestParam() String date) {
        return new AnalysisSubTableConverter(analysisDataService.getSubTableData(mainTableId, subTableId, date));
    }

}
