package com.ruoyi.report.domain.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.List;

/**
 * @author wzh
 * @date 2021年05月03日 10:26
 */
public class DailyTableData {
    private long tableId;
    private String tableName;

    private CommonData commonData;
    private List<BaseSubTableData> subTableDataList;

    public long getTableId() {
        return tableId;
    }

    public void setTableId(long tableId) {
        this.tableId = tableId;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public CommonData getCommonData() {
        return commonData;
    }

    public void setCommonData(CommonData commonData) {
        this.commonData = commonData;
    }

    public List<BaseSubTableData> getSubTableDataList() {
        return subTableDataList;
    }

    public void setSubTableDataList(List<BaseSubTableData> subTableDataList) {
        this.subTableDataList = subTableDataList;
    }

    @Override
    public String toString() {
        return "DailyTableData{" +
                "tableId=" + tableId +
                ", tableName='" + tableName + '\'' +
                ", commonData=" + commonData +
                ", subTableDataList=" + subTableDataList +
                '}';
    }
}
