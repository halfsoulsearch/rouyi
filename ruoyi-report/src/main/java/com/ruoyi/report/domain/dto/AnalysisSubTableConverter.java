package com.ruoyi.report.domain.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wzh
 * @date 2021年05月11日 18:02
 */
public class AnalysisSubTableConverter {
    private List<ColData> data = new ArrayList<>();

    public AnalysisSubTableConverter(AnalysisSubTableData source) {
        for (int i = 0; i < source.getRolNames().size(); i++) {
            ColData colData = new ColData();
            colData.setColName(source.getRolNames().get(i));
            colData.setColData(source.getData().get(i));
            data.add(colData);
        }
    }

    public List<ColData> getData() {
        return data;
    }

    public void setData(List<ColData> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "AnalysisSubTableConverter{" +
                "data=" + data +
                '}';
    }
}
