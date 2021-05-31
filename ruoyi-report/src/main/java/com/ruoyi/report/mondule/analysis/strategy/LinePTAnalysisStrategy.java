package com.ruoyi.report.mondule.analysis.strategy;

import com.ruoyi.report.domain.dto.AnalysisMetaData;
import com.ruoyi.report.domain.dto.NumberAnalysisMetaData;

import java.util.ArrayList;
import java.util.List;

public class LinePTAnalysisStrategy implements IAnalysisStrategy {
    @Override
    public void cal(List<String> cols, List<String> rows, List<List<AnalysisMetaData>> datas) {
        List<AnalysisMetaData> total1 = new ArrayList<>();
        for (int i = 0; i < cols.size(); i++) {
            NumberAnalysisMetaData meta = new NumberAnalysisMetaData();
            for (int j = 0; j < 2; j++) {
                List<AnalysisMetaData> analysisMetaData = datas.get(j);
                meta.setDailyValue(meta.getDailyValue() + ((NumberAnalysisMetaData)analysisMetaData.get(i)).getDailyValue());
                meta.setTotalValue(meta.getTotalValue() + ((NumberAnalysisMetaData)analysisMetaData.get(i)).getTotalValue());
            }
            total1.add(meta);
        }
        datas.add(2, total1);
        rows.add(2, "合计");

        List<AnalysisMetaData> total2 = new ArrayList<>();
        for (int i = 0; i < cols.size(); i++) {
            NumberAnalysisMetaData meta = new NumberAnalysisMetaData();
            for (int j = 3; j < 5; j++) {
                List<AnalysisMetaData> analysisMetaData = datas.get(j);
                meta.setDailyValue(meta.getDailyValue() + ((NumberAnalysisMetaData)analysisMetaData.get(i)).getDailyValue());
                meta.setTotalValue(meta.getTotalValue() + ((NumberAnalysisMetaData)analysisMetaData.get(i)).getTotalValue());
            }
            total2.add(meta);
        }
        datas.add(5, total2);
        rows.add(5, "合计");
    }

    @Override
    public String getName() {
        return "LINE_PT";
    }
}
