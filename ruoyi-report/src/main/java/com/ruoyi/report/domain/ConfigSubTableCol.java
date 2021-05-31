package com.ruoyi.report.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 子列的配置对象 config_sub_table_col
 * 
 * @author wzh
 * @date 2021-05-03
 */
public class ConfigSubTableCol extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long id;

    /** 主表id */
    @Excel(name = "主表id")
    private Long mainTableId;

    /** 字表id */
    @Excel(name = "字表id")
    private Long subTableId;

    /** 列名 */
    @Excel(name = "列名")
    private String name;

    /** 排序 */
    @Excel(name = "排序")
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
