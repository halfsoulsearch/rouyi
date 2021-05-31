package com.ruoyi.report.mondule.analysis.strategy;

import com.ruoyi.report.domain.dto.AnalysisMetaData;

import java.util.List;

public class DefaultAnalysisStrategy implements IAnalysisStrategy {
    @Override
    public void cal(List<String> cols, List<String> rows, List<List<AnalysisMetaData>> datas) {
    }

    @Override
    public String getName() {
        return "DEFAULT";
    }
}
