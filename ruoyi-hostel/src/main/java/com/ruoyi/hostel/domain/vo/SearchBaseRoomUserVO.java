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
 * 房间入住信息明细对象 base_room_user
 *
 * @author ruoyi
 * @date 2021-05-29
 */
@Data
public class SearchBaseRoomUserVO implements Serializable {


    private static final long serialVersionUID = 7892675804596722081L;
    /** 编号 */
    private Long id;

    /** 房间id */
    @Excel(name = "房间id")
    private Long roomId;

    /** 房间号 */
    @Excel(name = "房间号")
    private String roomNumber;

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


}
