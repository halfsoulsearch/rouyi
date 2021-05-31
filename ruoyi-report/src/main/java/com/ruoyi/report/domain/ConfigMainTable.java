package com.ruoyi.report.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 主的配置对象 config_main_table
 * 
 * @author llt
 * @date 2021-05-03
 */
public class ConfigMainTable extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    @Excel(name = "编号")
    private Long id;

    /** 主表名称 */
    @Excel(name = "主表名称")
    private String name;

    /** 路由地址 */
    @Excel(name = "路由地址")
    private String url;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setUrl(String url) 
    {
        this.url = url;
    }

    public String getUrl() 
    {
        return url;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("url", getUrl())
            .toString();
    }
}
