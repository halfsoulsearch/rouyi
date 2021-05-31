package com.ruoyi.report.mondule.analysis.creator;

import com.ruoyi.report.domain.ConfigShift;
import com.ruoyi.report.domain.ConfigSubTableCol;
import com.ruoyi.report.domain.ConfigSubTableRow;
import com.ruoyi.report.domain.dto.AnalysisMetaData;
import com.ruoyi.report.domain.dto.AnalysisSubTableData;
import com.ruoyi.report.domain.dto.NumberAnalysisMetaData;
import com.ruoyi.report.mondule.analysis.AnalysisValueUtils;
import com.ruoyi.report.mondule.analysis.strategy.IAnalysisStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author wzh
 * @date 2021年05月12日 9:07
 */
public class ColAnalysisCreator implements IAnalysisSubTableCreator {
    @Override
    public AnalysisSubTableData create(List<ConfigSubTableCol> configSubTableCols, List<ConfigSubTableRow> configSubTableRows, List<ConfigShift> configShifts, List<Map> dailyList, List<Map> totalList, IAnalysisStrategy strategy) {
        List<String> newCols = new ArrayList<>();
        List<String> newRows = new ArrayList<>();
        newRows.add("");
        List<List<AnalysisMetaData>> data = new ArrayList<>();
        List<AnalysisMetaData> itemList = new ArrayList<>();
        for (ConfigSubTableCol configSubTableCol : configSubTableCols) {
            newCols.add(configSubTableCol.getName());
            NumberAnalysisMetaData meta = new NumberAnalysisMetaData();
            meta.setDailyValue(AnalysisValueUtils.getTodayValue(dailyList, -1, configSubTableCol.getId(), -1));
            meta.setTotalValue(AnalysisValueUtils.getTotalValue(totalList, -1, configSubTableCol.getId(), -1));
            itemList.add(meta);
        }
        data.add(itemList);
        return new AnalysisSubTableData(newCols, newRows, data, strategy);
    }

    @Override
    public String getName() {
        return null;
    }
}
