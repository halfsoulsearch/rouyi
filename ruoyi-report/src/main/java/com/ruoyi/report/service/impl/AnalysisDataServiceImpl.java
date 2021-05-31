package com.ruoyi.report.service.impl;

import com.ruoyi.report.domain.ConfigShift;
import com.ruoyi.report.domain.ConfigSubTableCol;
import com.ruoyi.report.domain.ConfigSubTableRow;
import com.ruoyi.report.domain.dto.AnalysisSubTableData;
import com.ruoyi.report.mapper.*;
import com.ruoyi.report.mondule.analysis.SubTableAnalyst;
import com.ruoyi.report.service.IAnalysisDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wzh
 * @date 2021年05月03日 11:38
 */
@Service
public class AnalysisDataServiceImpl implements IAnalysisDataService {
    @Autowired
    private ConfigSubTableColMapper configSubTableColMapper;

    @Autowired
    private ConfigSubTableRowMapper configSubTableRowMapper;

    @Autowired
    private ConfigShiftMapper configShiftMapper;

    @Autowired
    private DayReportMapper dayReportMapper;



    @Autowired
    private SubTableAnalyst subTableAnalyst;

    @Override
    public AnalysisSubTableData getSubTableData(long mainTableId, long subTableId, String date) {
        ConfigSubTableCol col = new ConfigSubTableCol();
        col.setMainTableId(mainTableId);
        col.setSubTableId(subTableId);
        List<ConfigSubTableCol> configSubTableCols = configSubTableColMapper.selectConfigSubTableColList(col);
        ConfigSubTableRow row = new ConfigSubTableRow();
        row.setMainTableId(mainTableId);
        row.setSubTableId(subTableId);
        List<ConfigSubTableRow> configSubTableRows = configSubTableRowMapper.selectConfigSubTableRowList(row);

        ConfigShift configShift = new ConfigShift();
        configShift.setMainTableId(mainTableId);
        List<ConfigShift> configShifts = configShiftMapper.selectConfigShiftList(configShift);

        HashMap<String, String> param = new HashMap<>();
        param.put("mainTableId", mainTableId + "");
        param.put("subTableId", subTableId + "");
        param.put("date", date);
        List<Map> dailyList = dayReportMapper.dayReportAnalyse(param);
        List<Map> totalList = dayReportMapper.dayReportAnalyseTotal(param);

        return subTableAnalyst.analysis(subTableId, configSubTableCols, configSubTableRows, configShifts, dailyList, totalList);
    }
}
