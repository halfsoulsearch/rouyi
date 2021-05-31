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
public class CostAnalysisCreator implements IAnalysisSubTableCreator {
    @Override
    public AnalysisSubTableData create(List<ConfigSubTableCol> configSubTableCols, List<ConfigSubTableRow> configSubTableRows, List<ConfigShift> configShifts, List<Map> dailyList, List<Map> totalList, IAnalysisStrategy strategy) {
        List<String> newCols = new ArrayList<>();
        List<String> newRows = new ArrayList<>();
        List<List<AnalysisMetaData>> data = new ArrayList<>();
        for (int i = 0; i < configShifts.size(); i++) {
            ConfigShift shift = configShifts.get(i);
            newRows.add(shift.getName());
            List<AnalysisMetaData> itemList = new ArrayList<>();
            for (ConfigSubTableCol configSubTableCol : configSubTableCols) {
                if (i == 0) {
                    newCols.add(configSubTableCol.getName());
                }
                ConfigSubTableRow configSubTableRow = configSubTableRows.get(0);
                NumberAnalysisMetaData meta = new NumberAnalysisMetaData();
                double dailyValue = AnalysisValueUtils.getTodayValue(dailyList, shift.getId(), configSubTableCol.getId(), configSubTableRow.getId());
                double totalValue = AnalysisValueUtils.getTotalValue(totalList, shift.getId(), configSubTableCol.getId(), configSubTableRow.getId());
                meta.setDailyValue(dailyValue);
                meta.setTotalValue(totalValue);
                itemList.add(meta);
            }
            data.add(itemList);
        }
        List<AnalysisMetaData> itemList = new ArrayList<>();
        ConfigSubTableRow configSubTableRow = configSubTableRows.get(1);
        newRows.add(configSubTableRow.getName());
        for (ConfigSubTableCol configSubTableCol : configSubTableCols) {
            NumberAnalysisMetaData meta = new NumberAnalysisMetaData();
            double dailyValue = AnalysisValueUtils.getTodayValue(dailyList, -1, configSubTableCol.getId(), configSubTableRow.getId());
            double totalValue = AnalysisValueUtils.getTotalValue(totalList, -1, configSubTableCol.getId(), configSubTableRow.getId());
            meta.setDailyValue(dailyValue);
            meta.setTotalValue(totalValue);
            itemList.add(meta);
        }
        data.add(itemList);
        return new AnalysisSubTableData(newCols, newRows, data, strategy);
    }

    @Override
    public String getName() {
        return "COST";
    }
}
