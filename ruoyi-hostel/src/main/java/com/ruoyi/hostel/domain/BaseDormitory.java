package com.ruoyi.hostel.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 宿舍楼档案对象 base_dormitory
 * 
 * @author lfx
 * @date 2021-05-28
 */
public class BaseDormitory extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    @Excel(name = "id")
    private Long id;

    /** 楼号 */
    @Excel(name = "楼号")
    private String dormitoryCode;

    /** 楼名 */
    @Excel(name = "楼名")
    private String dormitoryName;

    /** 层数 */
    @Excel(name = "层数")
    private Integer layer;

    /** 门禁设备id */
    @Excel(name = "门禁设备id")
    private Long accessControlId;

    /** 区域 */
    @Excel(name = "区域")
    private String region;

    /** 创建人编号 */
    @Excel(name = "创建人编号")
    private String createCode;

    /** 创建人姓名 */
    @Excel(name = "创建人姓名")
    private String createName;

    /** 修改人编号 */
    @Excel(name = "修改人编号")
    private String updateCode;

    /** 修改人名称 */
    @Excel(name = "修改人名称")
    private String updateName;

    /** 是否删除 0未删除1删除 */
    @Excel(name = "是否删除 0未删除1删除")
    private Long isDeleted;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setDormitoryCode(String dormitoryCode) 
    {
        this.dormitoryCode = dormitoryCode;
    }

    public String getDormitoryCode() 
    {
        return dormitoryCode;
    }
    public void setDormitoryName(String dormitoryName) 
    {
        this.dormitoryName = dormitoryName;
    }

    public String getDormitoryName() 
    {
        return dormitoryName;
    }
    public void setLayer(Integer layer) 
    {
        this.layer = layer;
    }

    public Integer getLayer() 
    {
        return layer;
    }
    public void setAccessControlId(Long accessControlId) 
    {
        this.accessControlId = accessControlId;
    }

    public Long getAccessControlId() 
    {
        return accessControlId;
    }
    public void setRegion(String region) 
    {
        this.region = region;
    }

    public String getRegion() 
    {
        return region;
    }
    public void setCreateCode(String createCode) 
    {
        this.createCode = createCode;
    }

    public String getCreateCode() 
    {
        return createCode;
    }
    public void setCreateName(String createName) 
    {
        this.createName = createName;
    }

    public String getCreateName() 
    {
        return createName;
    }
    public void setUpdateCode(String updateCode) 
    {
        this.updateCode = updateCode;
    }

    public String getUpdateCode() 
    {
        return updateCode;
    }
    public void setUpdateName(String updateName) 
    {
        this.updateName = updateName;
    }

    public String getUpdateName() 
    {
        return updateName;
    }
    public void setIsDeleted(Long isDeleted) 
    {
        this.isDeleted = isDeleted;
    }

    public Long getIsDeleted() 
    {
        return isDeleted;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("dormitoryCode", getDormitoryCode())
            .append("dormitoryName", getDormitoryName())
            .append("layer", getLayer())
            .append("accessControlId", getAccessControlId())
            .append("region", getRegion())
            .append("createCode", getCreateCode())
            .append("createName", getCreateName())
            .append("updateCode", getUpdateCode())
            .append("updateName", getUpdateName())
            .append("isDeleted", getIsDeleted())
            .toString();
    }
}
