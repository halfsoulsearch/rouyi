package com.ruoyi.report.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 子行的配置
对象 config_sub_table_row
 * 
 * @author ruoyi
 * @date 2021-05-03
 */
public class ConfigSubTableRow extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 主表id */
    @Excel(name = "主表id")
    private Long mainTableId;

    /** 字表id */
    @Excel(name = "字表id")
    private Long subTableId;

    /** 行名 */
    @Excel(name = "行名")
    private String name;

    /** $column.columnComment */
    @Excel(name = "行名")
    private Integer order;

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
    public void setSubTableId(Long subTableId) 
    {
        this.subTableId = subTableId;
    }

    public Long getSubTableId() 
    {
        return subTableId;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setOrder(Integer order) 
    {
        this.order = order;
    }

    public Integer getOrder() 
    {
        return order;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("mainTableId", getMainTableId())
            .append("subTableId", getSubTableId())
            .append("name", getName())
            .append("order", getOrder())
            .toString();
    }
}
