package com.ruoyi.report.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 主基础数据信息
对象 data_base
 * 
 * @author ruoyi
 * @date 2021-05-03
 */
public class DataBase extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 主表id */
    @Excel(name = "主表id")
    private Long mainTableId;

    /** 录入用户id */
    @Excel(name = "录入用户id")
    private Long recordUserId;

    /** 状态 */
    @Excel(name = "状态")
    private Integer status;

    /** 报表日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "报表日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date date;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setMainTableId(Long mainTableId) 
    {
        this.mainTableId = mainTableId;
    }

    public Long getMainTableId() 
    {
        return mainTableId;
    }
    public void setRecordUserId(Long recordUserId) 
    {
        this.recordUserId = recordUserId;
    }

    public Long getRecordUserId() 
    {
        return recordUserId;
    }
    public void setStatus(Integer status) 
    {
        this.status = status;
    }

    public Integer getStatus() 
    {
        return status;
    }
    public void setDate(Date date) 
    {
        this.date = date;
    }

    public Date getDate() 
    {
        return date;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("mainTableId", getMainTableId())
            .append("updateTime", getUpdateTime())
            .append("createTime", getCreateTime())
            .append("recordUserId", getRecordUserId())
            .append("status", getStatus())
            .append("remark", getRemark())
            .append("createBy", getCreateBy())
            .append("updateBy", getUpdateBy())
            .append("date", getDate())
            .toString();
    }
}
