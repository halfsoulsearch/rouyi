package com.ruoyi.report.domain.dto;

import com.ruoyi.report.domain.DataValue;

import java.util.List;

/**
 * @author wzh
 * @date 2021年05月03日 10:50
 */
public class SurfaceSubTableData extends BaseSubTableData{
    public SurfaceSubTableData() {
        type = TABLE_TYPE_SURFACE;
    }

    List<String> colNameList;
    List<String> rowNameList;
    List<List<DataValue>> data;

    public List<String> getColNameList() {
        return colNameList;
    }

    public void setColNameList(List<String> colNameList) {
        this.colNameList = colNameList;
    }

    public List<String> getRowNameList() {
        return rowNameList;
    }

    public void setRowNameList(List<String> rowNameList) {
        this.rowNameList = rowNameList;
    }

    public List<List<DataValue>> getData() {
        return data;
    }

    public void setData(List<List<DataValue>> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "SurfaceSubTableData{" +
                "tableId=" + tableId +
                ", tableName='" + tableName + '\'' +
                ", colList=" + colNameList +
                ", rowList=" + rowNameList +
                ", data=" + data +
                '}';
    }
}
