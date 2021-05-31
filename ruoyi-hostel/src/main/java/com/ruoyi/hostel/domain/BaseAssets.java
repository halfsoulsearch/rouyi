package com.ruoyi.hostel.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 资产档案对象 base_assets
 * 
 * @author ruoyi
 * @date 2021-05-28
 */
@Data
@ApiModel("资产档案对象")
public class BaseAssets extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    @ApiModelProperty(value = "主键id")
    private Long id;

    /** 资产编号 */
    @Excel(name = "资产编号")
    @ApiModelProperty(value = "资产编号")
    private String assetsCode;

    /** 资产名称 枚举类型（单间、套间、家庭房） */
    @Excel(name = "资产名称")
    @ApiModelProperty(value = "资产名称")
    private String assetsName;

    /** 资产条码 */
    @Excel(name = "资产条码")
    @ApiModelProperty(value = "资产条码")
    private String assetsBarCode;

    /** 资产品牌 */
    @Excel(name = "资产品牌")
    @ApiModelProperty(value = "资产品牌")
    private String assetsBrand;

    /** 资产型号 枚举类型（空闲、满员、维修） */
    @Excel(name = "资产型号")
    @ApiModelProperty(value = "资产型号")
    private String assetsModel;

    /** 采购日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "采购日期", width = 30, dateFormat = "yyyy-MM-dd")
    @ApiModelProperty(value = "采购日期")
    private Date purchaseDate;

    /** 价格 单价 */
    @Excel(name = "价格 单价")
    @ApiModelProperty(value = "价格")
    private Double price;

    /** 创建人编号 */
    @Excel(name = "创建人编号")
    @ApiModelProperty(value = "创建人编号")
    private String createCode;

    /** 创建人姓名 */
    @Excel(name = "创建人姓名")
    @ApiModelProperty(value = "创建人姓名")
    private String createName;

    /** 修改人编号 */
    @Excel(name = "修改人编号")
    @ApiModelProperty(value = "修改人编号")
    private String updateCode;

    /** 修改人名称 */
    @Excel(name = "修改人名称")
    @ApiModelProperty(value = "修改人名称")
    private String updateName;

    /** 是否删除 0未删除1删除 */
    @Excel(name = "是否删除 0未删除1删除")
    @ApiModelProperty(value = "是否删除")
    private Long isDeleted;



    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("assetsCode", getAssetsCode())
            .append("assetsName", getAssetsName())
            .append("assetsBarCode", getAssetsBarCode())
            .append("assetsBrand", getAssetsBrand())
            .append("assetsModel", getAssetsModel())
            .append("purchaseDate", getPurchaseDate())
            .append("price", getPrice())
            .append("createCode", getCreateCode())
            .append("createName", getCreateName())
            .append("updateCode", getUpdateCode())
            .append("updateName", getUpdateName())
            .append("isDeleted", getIsDeleted())
            .toString();
    }
}
