package com.ruoyi.hostel.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 宿舍楼层档案对象 base_dormitory_layer
 * 
 * @author ruoyi
 * @date 2021-05-29
 */
public class BaseDormitoryLayer extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    @Excel(name = "id")
    private Long id;

    /** 宿舍楼id */
    @Excel(name = "宿舍楼id")
    private Long dormitoryId;

    /** 层号 */
    @Excel(name = "层号")
    private String layerNumber;

    /** 房间数 */
    @Excel(name = "房间数")
    private Long roomNumber;

    /** 门禁设备id */
    @Excel(name = "门禁设备id")
    private Long accessControlId;

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
    private Long isDeleted;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setDormitoryId(Long dormitoryId) 
    {
        this.dormitoryId = dormitoryId;
    }

    public Long getDormitoryId() 
    {
        return dormitoryId;
    }
    public void setLayerNumber(String layerNumber) 
    {
        this.layerNumber = layerNumber;
    }

    public String getLayerNumber() 
    {
        return layerNumber;
    }
    public void setRoomNumber(Long roomNumber) 
    {
        this.roomNumber = roomNumber;
    }

    public Long getRoomNumber() 
    {
        return roomNumber;
    }
    public void setAccessControlId(Long accessControlId) 
    {
        this.accessControlId = accessControlId;
    }

    public Long getAccessControlId() 
    {
        return accessControlId;
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
            .append("dormitoryId", getDormitoryId())
            .append("layerNumber", getLayerNumber())
            .append("roomNumber", getRoomNumber())
            .append("accessControlId", getAccessControlId())
            .append("createCode", getCreateCode())
            .append("createName", getCreateName())
            .append("updateCode", getUpdateCode())
            .append("updateName", getUpdateName())
            .append("isDeleted", getIsDeleted())
            .toString();
    }
}
