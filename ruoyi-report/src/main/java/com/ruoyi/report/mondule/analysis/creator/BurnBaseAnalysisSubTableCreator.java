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
public class BurnBaseAnalysisSubTableCreator implements IAnalysisSubTableCreator {
    @Override
    public AnalysisSubTableData create(List<ConfigSubTableCol> configSubTableCols, List<ConfigSubTableRow> configSubTableRows, List<ConfigShift> configShifts, List<Map> dailyList, List<Map> totalList, IAnalysisStrategy strategy) {
        List<String> newCols = new ArrayList<>();
        List<String> newRows = new ArrayList<>();
        List<List<AnalysisMetaData>> data = new ArrayList<>();
        for (int i = 0; i < configShifts.size(); i++) {
            ConfigShift shift = configShifts.get(i);
            List<AnalysisMetaData> itemList = new ArrayList<>();
            newRows.add(shift.getName());
            for (ConfigSubTableCol configSubTableCol : configSubTableCols) {
                for (ConfigSubTableRow configSubTableRow : configSubTableRows) {
                    if (i == 0) {
                        newCols.add(configSubTableRow.getName() + configSubTableCol.getName());
                    }
                    NumberAnalysisMetaData meta = new NumberAnalysisMetaData();
                    meta.setDailyValue(AnalysisValueUtils.getTodayValue(dailyList, shift.getId(), configSubTableCol.getId(), configSubTableRow.getId()));
                    meta.setTotalValue(AnalysisValueUtils.getTotalValue(totalList, shift.getId(), configSubTableCol.getId(), configSubTableRow.getId()));
                    itemList.add(meta);
                }
            }
            data.add(itemList);
        }

        return new AnalysisSubTableData(newCols, newRows, data, strategy);
    }

    @Override
    public String getName() {
        return "BURN_BASE";
    }
}
