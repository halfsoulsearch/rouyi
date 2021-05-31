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
public class ColSumShiftAnalysisCreator implements IAnalysisSubTableCreator {
    @Override
    public AnalysisSubTableData create(List<ConfigSubTableCol> configSubTableCols, List<ConfigSubTableRow> configSubTableRows, List<ConfigShift> configShifts, List<Map> dailyList, List<Map> totalList, IAnalysisStrategy strategy) {
        List<String> newCols = new ArrayList<>();
        List<String> newRows = new ArrayList<>();
        newRows.add("");
        List<List<AnalysisMetaData>> data = new ArrayList<>();
        List<AnalysisMetaData> itemList = new ArrayList<>();
        for (int i = 0; i < configSubTableCols.size(); i++) {
            NumberAnalysisMetaData meta = new NumberAnalysisMetaData();
            ConfigSubTableCol configSubTableCol = configSubTableCols.get(i);
            for (ConfigShift configShift : configShifts) {
                double todayValue = AnalysisValueUtils.getTodayValue(dailyList, configShift.getId(), configSubTableCol.getId(), -1);
                double totalValue = AnalysisValueUtils.getTodayValue(totalList, configShift.getId(), configSubTableCol.getId(), -1);
                meta.setDailyValue(meta.getDailyValue() + todayValue);
                meta.setTotalValue(meta.getTotalValue() + totalValue);
            }
            itemList.add(meta);
        }
        data.add(itemList);
        return new AnalysisSubTableData(newCols, newRows, data, strategy);
    }

    @Override
    public String getName() {
        return "COL_SUM_SHIFT";
    }
}
