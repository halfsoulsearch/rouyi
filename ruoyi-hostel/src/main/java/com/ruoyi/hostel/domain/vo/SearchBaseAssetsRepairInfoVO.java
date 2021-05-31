package com.ruoyi.hostel.domain.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;
import java.util.Date;

/**
 * 资产维修记录对象 base_assets_repair_info
 *
 * @author ruoyi
 * @date 2021-05-29
 */
@Data
public class SearchBaseAssetsRepairInfoVO extends BaseEntity implements Serializable {


    private static final long serialVersionUID = -3328085870687482594L;
    /**
     * id
     */
    private Long id;

    /**
     * 资产id
     */
    @Excel(name = "资产id")
    private Long assetsId;

    /**
     * 资产code
     */
    @Excel(name = "资产code")
    private String assetsCode;

    /**
     * 资产name
     */
    @Excel(name = "资产name")
    private String assetsName;

    /**
     * 所属房号
     */
    @Excel(name = "所属房号")
    private Long roomId;

    /**
     * 维修时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "维修时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date repairDate;

    /**
     * 维修原因
     */
    @Excel(name = "维修原因")
    private String repairReason;

    /**
     * 维修金额
     */
    @Excel(name = "维修金额")
    private Long repairPrice;

    /**
     * 创建人编码
     */
    @Excel(name = "创建人编码")
    private String createCode;

    /**
     * 创建日期 默认为当前时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "创建日期 默认为当前时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date createDate;

    /**
     * 是否删除 0未删除1已删除
     */
    @Excel(name = "是否删除 0未删除1已删除")
    private Long isDeleted;


}
