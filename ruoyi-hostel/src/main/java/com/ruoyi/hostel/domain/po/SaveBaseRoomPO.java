package com.ruoyi.hostel.domain.po;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

/**
 * 房间档案对象 base_room
 * 
 * @author ruoyi
 * @date 2021-05-28
 */
@Data
@ApiModel
public class SaveBaseRoomPO extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 5851303260680963123L;
    /** id */
    @Excel(name = "id")
    private Long id;

    /**
     * 楼id
     */
    private Long dormitoryId;

    //楼号
    private String dormitoryNumber;

    /** 楼层id */
    @Excel(name = "楼层id")
    private Long layerId;

    //层号
    private String layerNumber;

    /** 房间类型 */
    @Excel(name = "房间类型")
    private String roomType;

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


}
