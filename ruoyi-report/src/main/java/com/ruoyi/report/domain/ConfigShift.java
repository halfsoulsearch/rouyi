package com.ruoyi.report.domain;

import java.util.List;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 班次对象 config_shift
 * 
 * @author wzy
 * @date 2021-05-02
 */
public class ConfigShift extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    @Excel(name = "编号")
    private Long id;

    /** 主表编号 */
    @Excel(name = "主表编号")
    private Long mainTableId;

    /** 班次名称 */
    @Excel(name = "班次名称")
    private String name;

    /** 主的配置信息 */
    private List<ConfigMainTable> configMainTableList;

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

    public List<ConfigMainTable> getConfigMainTableList()
    {
        return configMainTableList;
    }

    public void setConfigMainTableList(List<ConfigMainTable> configMainTableList)
    {
        this.configMainTableList = configMainTableList;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("mainTableId", getMainTableId())
            .append("name", getName())
            .append("configMainTableList", getConfigMainTableList())
            .toString();
    }
}
