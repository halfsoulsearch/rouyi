package com.ruoyi.report.domain.dto;

import com.ruoyi.report.domain.DataValue;

import java.util.List;

/**
 * @author wzh
 * @date 2021年05月03日 10:50
 */
public class PointSubTableData extends BaseSubTableData{
    public PointSubTableData() {
        type = TABLE_TYPE_POINT;
    }

    DataValue data;

    public DataValue getData() {
        return data;
    }

    public void setData(DataValue data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "PointSubTableData{" +
                "tableId=" + tableId +
                ", tableName='" + tableName + '\'' +
                ", data=" + data +
                '}';
    }
}
