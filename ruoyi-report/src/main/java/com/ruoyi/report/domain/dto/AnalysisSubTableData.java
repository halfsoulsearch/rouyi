package com.ruoyi.report.domain.dto;

import com.ruoyi.report.mondule.analysis.strategy.IAnalysisStrategy;

import java.util.List;

/**
 * @author wzh
 * @date 2021年05月11日 10:10
 */
public class AnalysisSubTableData {
    private List<String> colNames;
    private List<String> rolNames;
    private List<List<AnalysisMetaData>> data;
    private IAnalysisStrategy strategy;

    public AnalysisSubTableData(List<String> colNames, List<String> rolNames, List<List<AnalysisMetaData>> data, IAnalysisStrategy strategy) {
        this.colNames = colNames;
        this.rolNames = rolNames;
        this.data = data;
        this.strategy = strategy;
        this.strategy.cal(colNames, rolNames, data);
    }

    public List<String> getColNames() {
        return colNames;
    }

    public List<String> getRolNames() {
        return rolNames;
    }

    public List<List<AnalysisMetaData>> getData() {
        return data;
    }

    @Override
    public String toString() {
        return "AnalysisSubTableData{" +
                "colNames=" + colNames +
                ", rolNames=" + rolNames +
                ", data=" + data +
                '}';
    }
}
