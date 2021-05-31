package com.ruoyi.hostel.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 房间档案对象 base_room
 * 
 * @author ruoyi
 * @date 2021-05-28
 */
@Data
public class BaseRoom extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    @Excel(name = "id")
    private Long id;

    /** 楼层id */
    @Excel(name = "楼id")
    private Long dormitoryId;

    /** 楼层id */
    @Excel(name = "楼层id")
    private Long layerId;

    /** 房间类型 */
    @Excel(name = "房间类型")
    private String roomType;

    /** 房间编码 */
    @Excel(name = "房间编码")
    private String roomCode;

    /** 房间号 */
    @Excel(name = "房间号")
    private String roomNumber;

    /** 房间标准 */
    @Excel(name = "房间标准")
    private String roomStandard;

    /** 房间状态 */
    @Excel(name = "房间状态")
    private String roomState;

    /** 房间入住标准 */
    @Excel(name = "房间入住标准")
    private Long roomRank;

    /** 智能电表编号 */
    @Excel(name = "智能电表编号")
    private String electricCode;

    /** 智能电表地址 */
    @Excel(name = "智能电表地址")
    private String electricPlace;

    /** 智能水表编号 */
    @Excel(name = "智能水表编号")
    private String waterCode;

    /** 只能水表地址 */
    @Excel(name = "只能水表地址")
    private String waterPlace;

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


}
