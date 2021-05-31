package com.ruoyi.report.domain.dto;

import java.util.List;

/**
 * @author wzh
 * @date 2021年05月11日 18:13
 */
public class ColData {
    private String colName;
    private List<AnalysisMetaData> colData;

    public String getColName() {
        return colName;
    }

    public void setColName(String colName) {
        this.colName = colName;
    }

    public List<AnalysisMetaData> getColData() {
        return colData;
    }

    public void setColData(List<AnalysisMetaData> colData) {
        this.colData = colData;
    }

    @Override
    public String toString() {
        return "ColData{" +
                "colName='" + colName + '\'' +
                ", colData=" + colData +
                '}';
    }
}
