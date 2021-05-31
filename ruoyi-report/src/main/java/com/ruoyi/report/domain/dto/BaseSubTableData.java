package com.ruoyi.report.domain.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * @author wzh
 * @date 2021年05月03日 10:50
 */
@JsonDeserialize
public abstract class BaseSubTableData {
    public static final int TABLE_TYPE_POINT = 1;
    public static final int TABLE_TYPE_LINE = 2;
    public static final int TABLE_TYPE_SURFACE = 3;

    long tableId;
    String tableName;
    int type;

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

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
