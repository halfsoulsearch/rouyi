package com.ruoyi.report.domain.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.core.domain.BaseEntity;

import java.util.Date;

public class DayReport extends BaseEntity {

    private long id;
    private long mainTableId;
    private long recordUserId;
    private int status;
    private String tableName;
    private String userName;
    private String nickName;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date date;

    private String url;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getMainTableId() {
        return mainTableId;
    }

    public void setMainTableId(long mainTableId) {
        this.mainTableId = mainTableId;
    }

    public long getRecordUserId() {
        return recordUserId;
    }

    public void setRecordUserId(long recordUserId) {
        this.recordUserId = recordUserId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
