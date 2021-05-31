package com.ruoyi.hostel.service;

import com.ruoyi.hostel.domain.BaseRoom;
import com.ruoyi.hostel.domain.po.SaveBaseRoomPO;
import com.ruoyi.hostel.domain.po.SearchBaseRoomPO;
import com.ruoyi.hostel.domain.vo.SearchBaseRoomVO;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * 房间档案Service接口
 * 
 * @author ruoyi
 * @date 2021-05-28
 */
public interface IBaseRoomService 
{
    /**
     * 查询房间档案
     * 
     * @param id 房间档案ID
     * @return 房间档案
     */
    public BaseRoom selectBaseRoomById(Long id);

    /**
     * 查询房间档案列表
     * 
     * @param baseRoom 房间档案
     * @return 房间档案集合
     */
    public List<SearchBaseRoomVO> selectBaseRoomList(SearchBaseRoomPO request);

    /**
     * 新增房间档案
     * 
     * @param baseRoom 房间档案
     * @return 结果
     */
    public int insertBaseRoom(BaseRoom baseRoom);


    /**
     * 房间档案新增
     * @param request
     * @return
     */
    int saveRoom( SaveBaseRoomPO request);

    /**
     * 修改房间档案
     * 
     * @param baseRoom 房间档案
     * @return 结果
     */
    public int updateBaseRoom(BaseRoom baseRoom);

    /**
     * 批量删除房间档案
     * 
     * @param ids 需要删除的房间档案ID
     * @return 结果
     */
    public int deleteBaseRoomByIds(Long[] ids);

    /**
     * 删除房间档案信息
     * 
     * @param id 房间档案ID
     * @return 结果
     */
    public int deleteBaseRoomById(Long id);
}
