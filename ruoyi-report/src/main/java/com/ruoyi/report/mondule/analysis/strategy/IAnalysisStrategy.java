package com.ruoyi.report.mondule.analysis.strategy;

import com.ruoyi.report.domain.dto.AnalysisMetaData;

import java.util.List;

public interface IAnalysisStrategy {
    void cal(List<String> cols, List<String> rows, List<List<AnalysisMetaData>> datas);

    String getName();
}
