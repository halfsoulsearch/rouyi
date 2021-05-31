package com.ruoyi.report.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 子的配置对象 config_sub_table
 *
 * @author ruoyi
 * @date 2021-05-03
 */
public class ConfigSubTable extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 主表id */
    @Excel(name = "主表id")
    private Long mainTableId;

    /** 子表名 */
    @Excel(name = "子表名")
    private String name;

    /** 排序 */
    @Excel(name = "排序")
    private Integer order;

    /** 策略 */
    @Excel(name = "策略")
    private String analysisStrategy;

    /** 创建者 */
    @Excel(name = "创建者")
    private String analysisCreator;

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

    public String getAnalysisStrategy() {
        return analysisStrategy;
    }

    public void setAnalysisStrategy(String analysisStrategy) {
        this.analysisStrategy = analysisStrategy;
    }

    public String getAnalysisCreator() {
        return analysisCreator;
    }

    public void setAnalysisCreator(String analysisCreator) {
        this.analysisCreator = analysisCreator;
    }

    @Override
    public String toString() {
        return "ConfigSubTable{" +
                "id=" + id +
                ", mainTableId=" + mainTableId +
                ", name='" + name + '\'' +
                ", order=" + order +
                ", analysisStrategy='" + analysisStrategy + '\'' +
                '}';
    }
}
