package com.ruoyi.report.controller;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.report.domain.ConfigMainTable;
import com.ruoyi.report.domain.ConfigShift;
import com.ruoyi.report.domain.ConfigSubTable;
import com.ruoyi.report.domain.response.Result;
import com.ruoyi.report.domain.vo.DayReport;
import com.ruoyi.report.service.IConfigMainTableService;
import com.ruoyi.report.service.IConfigShiftService;
import com.ruoyi.report.service.IConfigSubTableService;
import com.ruoyi.report.service.IDayReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 +-------------------------------------------------------
 | 描述：日报表返回类
 +--------------------------------------------------------
 | 作者：llt
 +--------------------------------------------------------
 | 版权：Copyright (c) 2021 晋钢集团 All rights reserved.
 +--------------------------------------------------------
 | 日期：2021-5-10 16:13:47
 +--------------------------------------------------------
 **/
@RestController
@RequestMapping("/report/dayreport")
public class DayReportController extends BaseController {

    @Autowired
    private IDayReportService dayReportService;
    @Autowired
    private IConfigMainTableService configMainTableService;
    @Autowired
    private IConfigSubTableService configSubTableService;
    /**
     * 查询列表
     */
    @PreAuthorize("@ss.hasPermi('report:dayreport:list')")
    @GetMapping("/list")
    public TableDataInfo list(DayReport dayReport)
    {
        startPage();
        List<DayReport> list = dayReportService.selectDayReportList(dayReport);
        return getDataTable(list);
    }

    @PreAuthorize("@ss.hasPermi('report:dayreport:list')")
    @GetMapping("/ballDayReportAnalyse")
    public Result<List<Map>> ballDayReportAnalyse(long mainTableId,String date){

        Result<List<Map>> result = new Result<List<Map>>();
        selectData(mainTableId,date);
        return result;
    }



    public Map selectData(long mainTableId,String date){

        Map params = new HashMap<String,String>();
        params.put("mainTableId",mainTableId);
        params.put("date",date);
        //查询主表信息
        ConfigMainTable configMainTable = configMainTableService.selectConfigMainTableById(mainTableId);
        ConfigSubTable configSubTable = new ConfigSubTable();
        configSubTable.setMainTableId(configMainTable.getId());
        //获取所有的字表信息
        List<ConfigSubTable> configSubTables = configSubTableService.selectConfigSubTableList(configSubTable);
        for (int i = 0; i < configSubTables.size(); i++) {
            params.put("subTableId",configSubTables.get(i).getId());
            //当日数据
            List<Map> maps = dayReportService.ballDayReportAnalyse(params);
            //累计
            List<Map> maps1 = dayReportService.ballDayReportAnalyseTotal(params);

            System.out.println("maps = " + maps);
            System.out.println("maps1 = " + maps1);

            break;
        }
        return null;
    }
}
