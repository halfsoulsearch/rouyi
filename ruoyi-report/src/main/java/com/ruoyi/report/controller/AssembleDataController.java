package com.ruoyi.report.controller;

import com.alibaba.fastjson.JSONObject;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.report.domain.dto.DailyTableData;
import com.ruoyi.report.domain.vo.DayReport;
import com.ruoyi.report.service.IAssembleDataService;
import com.ruoyi.report.service.IDayReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @author wzh
 */
@RestController
@RequestMapping("/report/assembleData")
public class AssembleDataController extends BaseController {

    @Autowired
    private IAssembleDataService assembleDataService;


    @PreAuthorize("@ss.hasPermi('report:dayreport:list')")
    @GetMapping("/preCreate")
    public DailyTableData preCreate(@RequestParam long mainTableId, @RequestParam(required=false, defaultValue = "") String date, @RequestParam long shiftId, @RequestParam long userId) {
        return assembleDataService.preCreateTable(mainTableId, date, shiftId, userId);
    }

    @PreAuthorize("@ss.hasPermi('report:dayreport:list')")
    @GetMapping("/getData")
    public DailyTableData getData(@RequestParam long baseTableId, @RequestParam(required=false, defaultValue = "-1") long shiftId) {
        return assembleDataService.getTableData(baseTableId, shiftId);
    }

    @PreAuthorize("@ss.hasPermi('report:dayreport:list')")
    @PostMapping("/createOrUpdate")
    public void create(@RequestBody JSONObject object) {
        assembleDataService.createOrUpdateTable(object);
    }
}
