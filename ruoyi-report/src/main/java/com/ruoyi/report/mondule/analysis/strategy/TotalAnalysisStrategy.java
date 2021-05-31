package com.ruoyi.report.mondule.analysis.strategy;

import com.ruoyi.report.domain.dto.AnalysisMetaData;
import com.ruoyi.report.domain.dto.NumberAnalysisMetaData;

import java.util.ArrayList;
import java.util.List;

public class TotalAnalysisStrategy implements IAnalysisStrategy {
    @Override
    public void cal(List<String> cols, List<String> rows, List<List<AnalysisMetaData>> datas) {
        rows.add("合计");
        List<AnalysisMetaData> total = new ArrayList<>();
        for (int i = 0; i < cols.size(); i++) {
            NumberAnalysisMetaData meta = new NumberAnalysisMetaData();
            for (List<AnalysisMetaData> data : datas) {
                meta.setDailyValue(meta.getDailyValue() + ((NumberAnalysisMetaData)data.get(i)).getDailyValue());
                meta.setTotalValue(meta.getTotalValue() + ((NumberAnalysisMetaData)data.get(i)).getTotalValue());
            }
            total.add(meta);
        }
        datas.add(total);
    }

    @Override
    public String getName() {
        return "TOTAL";
    }
}
