package com.ruoyi.report.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 具体数据对象 data_value
 *
 * @author wzh
 * @date 2021-05-03
 */
public class DataValue extends BaseEntity
{
    public static final int VALUE_TYPE_NUMBER = 0;
    public static final int VALUE_TYPE_TEXT = 1;

    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 主表编号 */
    @Excel(name = "主表编号")
    private Long mainTableId;

    /** 字表编号 */
    @Excel(name = "字表编号")
    private Long subTableId;

    /** 列id */
    @Excel(name = "列id")
    private Long colId;

    /** 行id */
    @Excel(name = "行id")
    private Long rowId;

    /** 日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date date;

    /** 班次id */
    @Excel(name = "班次id")
    private Long shiftId;

    /** 值的类型 */
    @Excel(name = "值的类型")
    private Integer valueType;

    /** 数字的值 */
    @Excel(name = "数字的值")
    private BigDecimal valueNumber;

    /** 字符串的值 */
    @Excel(name = "字符串的值")
    private String valueText;

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
    public void setColId(Long colId)
    {
        this.colId = colId;
    }

    public Long getColId()
    {
        return colId;
    }
    public void setRowId(Long rowId)
    {
        this.rowId = rowId;
    }

    public Long getRowId()
    {
        return rowId;
    }
    public void setDate(Date date)
    {
        this.date = date;
    }

    public Date getDate()
    {
        return date;
    }
    public void setShiftId(Long shiftId)
    {
        this.shiftId = shiftId;
    }

    public Long getShiftId()
    {
        return shiftId;
    }
    public void setValueType(Integer valueType)
    {
        this.valueType = valueType;
    }

    public Integer getValueType()
    {
        return valueType;
    }
    public void setValueNumber(BigDecimal valueNumber)
    {
        this.valueNumber = valueNumber;
    }

    public BigDecimal getValueNumber()
    {
        return valueNumber;
    }
    public void setValueText(String valueText)
    {
        this.valueText = valueText;
    }

    public String getValueText()
    {
        return valueText;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("mainTableId", getMainTableId())
            .append("subTableId", getSubTableId())
            .append("colId", getColId())
            .append("rowId", getRowId())
            .append("date", getDate())
            .append("shiftId", getShiftId())
            .append("valueType", getValueType())
            .append("valueNumber", getValueNumber())
            .append("valueText", getValueText())
            .toString();
    }
}
