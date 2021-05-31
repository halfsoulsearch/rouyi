package com.ruoyi.report.domain.dto;

import com.ruoyi.report.domain.DataValue;

import java.util.List;

/**
 * @author wzh
 * @date 2021年05月03日 10:50
 */
public class LineSubTableData extends BaseSubTableData{
    public LineSubTableData() {
        type = TABLE_TYPE_LINE;
    }

    List<String> colNameList;
    List<DataValue> data;

    public List<String> getColNameList() {
        return colNameList;
    }

    public void setColNameList(List<String> colNameList) {
        this.colNameList = colNameList;
    }

    public List<DataValue> getData() {
        return data;
    }

    public void setData(List<DataValue> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "lineSubTableData{" +
                "tableId=" + tableId +
                ", tableName='" + tableName + '\'' +
                ", colNameList=" + colNameList +
                ", data=" + data +
                '}';
    }
}
