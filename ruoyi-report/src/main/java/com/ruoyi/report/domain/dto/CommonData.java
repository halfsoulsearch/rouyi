package com.ruoyi.report.domain.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @author wzh
 * @date 2021年05月03日 10:26
 */
public class CommonData {
    public static final int STATUS_CREATE = 0;
    public static final int STATUS_AUDIT = 1;
    public static final int STATUS_CLOSE = 2;

    private long id;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date date;
    private long shiftId;
    private int status;
    private long userId;
    private long mainTableId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public long getShiftId() {
        return shiftId;
    }

    public void setShiftId(long shiftId) {
        this.shiftId = shiftId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getMainTableId() {
        return mainTableId;
    }

    public void setMainTableId(long mainTableId) {
        this.mainTableId = mainTableId;
    }
}
