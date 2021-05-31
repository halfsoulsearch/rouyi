package com.ruoyi.hostel.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 房间入住信息明细对象 base_room_user
 *
 * @author ruoyi
 * @date 2021-05-29
 */
public class BaseRoomUser extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    private Long id;

    /** 房间id */
    @Excel(name = "房间id")
    private Long roomId;

    /** 工号 */
    @Excel(name = "工号")
    private String userCode;

    /** 员工名称 */
    @Excel(name = "员工名称")
    private String userName;

    /** 入住开始时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "入住开始时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date startDate;

    /** 结束时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "结束时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date endDate;

    /** 创建人编号 当前用户ID */
    @Excel(name = "创建人编号 当前用户ID")
    private String createCode;

    /** 创建日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "创建日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date createDate;

    /** 是否删除 0正常1删除 */
    @Excel(name = "是否删除 0正常1删除")
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
    public void setUserCode(String userCode)
    {
        this.userCode = userCode;
    }

    public String getUserCode()
    {
        return userCode;
    }
    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public String getUserName()
    {
        return userName;
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
            .append("roomId", getRoomId())
            .append("userCode", getUserCode())
            .append("userName", getUserName())
            .append("startDate", getStartDate())
            .append("endDate", getEndDate())
            .append("createCode", getCreateCode())
            .append("createDate", getCreateDate())
            .append("isDeleted", getIsDeleted())
            .toString();
    }
}
