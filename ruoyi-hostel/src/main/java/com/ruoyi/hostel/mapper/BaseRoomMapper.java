package com.ruoyi.hostel.mapper;

import java.util.List;

import com.ruoyi.hostel.domain.BaseRoom;
import com.ruoyi.hostel.domain.po.SearchBaseRoomPO;
import com.ruoyi.hostel.domain.vo.SearchBaseRoomVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 房间档案Mapper接口
 *
 * @author ruoyi
 * @date 2021-05-28
 */
@Repository
public interface BaseRoomMapper {
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
    List<SearchBaseRoomVO> selectBaseRoomList(@Param("request") SearchBaseRoomPO request);

    /**
     * 新增房间档案
     *
     * @param baseRoom 房间档案
     * @return 结果
     */
    public int insertBaseRoom(BaseRoom baseRoom);

    /**
     * 修改房间档案
     *
     * @param baseRoom 房间档案
     * @return 结果
     */
    public int updateBaseRoom(BaseRoom baseRoom);

    /**
     * 删除房间档案
     *
     * @param id 房间档案ID
     * @return 结果
     */
    public int deleteBaseRoomById(Long id);

    /**
     * 批量删除房间档案
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteBaseRoomByIds(Long[] ids);
}
