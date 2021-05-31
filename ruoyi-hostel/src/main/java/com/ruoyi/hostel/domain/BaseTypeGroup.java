package com.ruoyi.hostel.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.TreeEntity;

/**
 * 类型组对象 base_type_group
 * 
 * @author ruoyi
 * @date 2021-05-29
 */
public class BaseTypeGroup extends TreeEntity
{
    private static final long serialVersionUID = 1L;

    /** 类别id */
    @Excel(name = "类别id")
    private Long baseTypeId;

    /** 类别名称 */
    @Excel(name = "类别名称")
    private String typeName;

    /** 类型组别 */
    @Excel(name = "类型组别")
    private Integer typeGroupNum;

    /** 类型组别名称 */
    @Excel(name = "类型组别名称")
    private String typeGroupName;

    /** 资产类别状态（0正常 1停用） */
    @Excel(name = "资产类别状态", readConverterExp = "0=正常,1=停用")
    private String status;

    /** 删除标志（0代表存在 2代表删除） */
    private String delFlag;

    public void setBaseTypeId(Long baseTypeId) 
    {
        this.baseTypeId = baseTypeId;
    }

    public Long getBaseTypeId() 
    {
        return baseTypeId;
    }
    public void setTypeName(String typeName) 
    {
        this.typeName = typeName;
    }

    public String getTypeName() 
    {
        return typeName;
    }
    public void setTypeGroupNum(Integer typeGroupNum) 
    {
        this.typeGroupNum = typeGroupNum;
    }

    public Integer getTypeGroupNum() 
    {
        return typeGroupNum;
    }
    public void setTypeGroupName(String typeGroupName) 
    {
        this.typeGroupName = typeGroupName;
    }

    public String getTypeGroupName() 
    {
        return typeGroupName;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }
    public void setDelFlag(String delFlag) 
    {
        this.delFlag = delFlag;
    }

    public String getDelFlag() 
    {
        return delFlag;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("baseTypeId", getBaseTypeId())
            .append("parentId", getParentId())
            .append("ancestors", getAncestors())
            .append("typeName", getTypeName())
            .append("orderNum", getOrderNum())
            .append("typeGroupNum", getTypeGroupNum())
            .append("typeGroupName", getTypeGroupName())
            .append("status", getStatus())
            .append("delFlag", getDelFlag())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
