package com.ruoyi.hostel.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 资产维修记录对象 base_assets_repair_info
 * 
 * @author ruoyi
 * @date 2021-05-29
 */
public class BaseAssetsRepairInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 资产id */
    @Excel(name = "资产id")
    private Long assetsId;

    /** 资产code */
    @Excel(name = "资产code")
    private String assetsCode;

    /** 资产name */
    @Excel(name = "资产name")
    private String assetsName;

    /** 所属房号 */
    @Excel(name = "所属房号")
    private Long roomId;

    /** 维修时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "维修时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date repairDate;

    /** 维修原因 */
    @Excel(name = "维修原因")
    private String repairReason;

    /** 维修金额 */
    @Excel(name = "维修金额")
    private Long repairPrice;

    /** 创建人编码 */
    @Excel(name = "创建人编码")
    private String createCode;

    /** 创建日期 默认为当前时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "创建日期 默认为当前时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date createDate;

    /** 是否删除 0未删除1已删除 */
    @Excel(name = "是否删除 0未删除1已删除")
    private Long isDeleted;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setAssetsId(Long assetsId) 
    {
        this.assetsId = assetsId;
    }

    public Long getAssetsId() 
    {
        return assetsId;
    }
    public void setAssetsCode(String assetsCode) 
    {
        this.assetsCode = assetsCode;
    }

    public String getAssetsCode() 
    {
        return assetsCode;
    }
    public void setAssetsName(String assetsName) 
    {
        this.assetsName = assetsName;
    }

    public String getAssetsName() 
    {
        return assetsName;
    }
    public void setRoomId(Long roomId) 
    {
        this.roomId = roomId;
    }

    public Long getRoomId() 
    {
        return roomId;
    }
    public void setRepairDate(Date repairDate) 
    {
        this.repairDate = repairDate;
    }

    public Date getRepairDate() 
    {
        return repairDate;
    }
    public void setRepairReason(String repairReason) 
    {
        this.repairReason = repairReason;
    }

    public String getRepairReason() 
    {
        return repairReason;
    }
    public void setRepairPrice(Long repairPrice) 
    {
        this.repairPrice = repairPrice;
    }

    public Long getRepairPrice() 
    {
        return repairPrice;
    }
    public void setCreateCode(String createCode) 
    {
        this.createCode = createCode;
    }

    public String getCreateCode() 
    {
        return createCode;
    }
    public void setCreateDate(Date createDate) 
    {
        this.createDate = createDate;
    }

    public Date getCreateDate() 
    {
        return createDate;
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
            .append("assetsId", getAssetsId())
            .append("assetsCode", getAssetsCode())
            .append("assetsName", getAssetsName())
            .append("roomId", getRoomId())
            .append("repairDate", getRepairDate())
            .append("repairReason", getRepairReason())
            .append("repairPrice", getRepairPrice())
            .append("createCode", getCreateCode())
            .append("createDate", getCreateDate())
            .append("isDeleted", getIsDeleted())
            .toString();
    }
}
