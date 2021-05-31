package com.ruoyi.report.mondule.analysis.strategy;

import com.ruoyi.report.domain.dto.AnalysisMetaData;
import com.ruoyi.report.domain.dto.NumberAnalysisMetaData;

import java.util.ArrayList;
import java.util.List;

public class CostAnalysisStrategy implements IAnalysisStrategy {
    @Override
    public void cal(List<String> cols, List<String> rows, List<List<AnalysisMetaData>> datas) {
        List<AnalysisMetaData> total = new ArrayList<>();
        for (int i = 0; i < cols.size(); i++) {
            NumberAnalysisMetaData meta = new NumberAnalysisMetaData();
            for (int j = 0; j < datas.size() - 1; j++) {
                NumberAnalysisMetaData metaData = (NumberAnalysisMetaData)datas.get(j).get(i);
                meta.setDailyValue(meta.getDailyValue() +metaData.getDailyValue());
                meta.setTotalValue(meta.getTotalValue() + metaData.getTotalValue());
            }
            total.add(meta);
        }
        datas.add(datas.size() - 1, total);
        rows.add(datas.size() - 2, "合计");
    }

    @Override
    public String getName() {
        return "COST";
    }
}
