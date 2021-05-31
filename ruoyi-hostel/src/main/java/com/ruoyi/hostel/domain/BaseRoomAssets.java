package com.ruoyi.hostel.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 房间资产关系对象 base_room_assets
 * 
 * @author ruoyi
 * @date 2021-05-29
 */
public class BaseRoomAssets extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 房间id */
    @Excel(name = "房间id")
    private Long roomId;

    /** 资产id */
    @Excel(name = "资产id")
    private Long assetsId;

    /** 开始时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "开始时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date startDate;

    /** 结束时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "结束时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date endDate;

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
    public void setRoomId(Long roomId) 
    {
        this.roomId = roomId;
    }

    public Long getRoomId() 
    {
        return roomId;
    }
    public void setAssetsId(Long assetsId) 
    {
        this.assetsId = assetsId;
    }

    public Long getAssetsId() 
    {
        return assetsId;
    }
    public void setStartDate(Date startDate) 
    {
        this.startDate = startDate;
    }

    public Date getStartDate() 
    {
        return startDate;
    }
    public void setEndDate(Date endDate) 
    {
        this.endDate = endDate;
    }

    public Date getEndDate() 
    {
        return endDate;
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
            .append("roomId", getRoomId())
            .append("assetsId", getAssetsId())
            .append("startDate", getStartDate())
            .append("endDate", getEndDate())
            .append("isDeleted", getIsDeleted())
            .toString();
    }
}
