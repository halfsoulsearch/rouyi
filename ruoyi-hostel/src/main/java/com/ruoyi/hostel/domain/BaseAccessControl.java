package com.ruoyi.hostel.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 门禁设备对象 base_access_control
 * 
 * @author ruoyi
 * @date 2021-05-28
 */
public class BaseAccessControl extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    @Excel(name = "主键")
    private Long id;

    /** 编码 */
    @Excel(name = "编码")
    private String acCode;

    /** 名称 */
    @Excel(name = "名称")
    private String acName;

    /** 门禁地址 */
    @Excel(name = "门禁地址")
    private String acPlace;

    /** 创建人工号 */
    @Excel(name = "创建人工号")
    private String createCode;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date createDate;

    /** 修改人工号 */
    @Excel(name = "修改人工号")
    private String updateCode;

    /** 修改时间 */
    @Excel(name = "修改时间")
    private String updateDate;

    /** 是否删除 */
    @Excel(name = "是否删除")
    private Long isDeleted;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setAcCode(String acCode) 
    {
        this.acCode = acCode;
    }

    public String getAcCode() 
    {
        return acCode;
    }
    public void setAcName(String acName) 
    {
        this.acName = acName;
    }

    public String getAcName() 
    {
        return acName;
    }
    public void setAcPlace(String acPlace) 
    {
        this.acPlace = acPlace;
    }

    public String getAcPlace() 
    {
        return acPlace;
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
    public void setUpdateCode(String updateCode) 
    {
        this.updateCode = updateCode;
    }

    public String getUpdateCode() 
    {
        return updateCode;
    }
    public void setUpdateDate(String updateDate) 
    {
        this.updateDate = updateDate;
    }

    public String getUpdateDate() 
    {
        return updateDate;
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
            .append("acCode", getAcCode())
            .append("acName", getAcName())
            .append("acPlace", getAcPlace())
            .append("createCode", getCreateCode())
            .append("createDate", getCreateDate())
            .append("updateCode", getUpdateCode())
            .append("updateDate", getUpdateDate())
            .append("isDeleted", getIsDeleted())
            .toString();
    }
}
