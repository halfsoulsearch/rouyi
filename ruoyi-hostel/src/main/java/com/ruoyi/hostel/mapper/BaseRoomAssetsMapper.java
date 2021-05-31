package com.ruoyi.hostel.mapper;

import com.ruoyi.hostel.domain.BaseRoomAssets;

import java.util.List;


/**
 * 房间资产关系Mapper接口
 * 
 * @author ruoyi
 * @date 2021-05-29
 */
public interface BaseRoomAssetsMapper 
{
    /**
     * 查询房间资产关系
     * 
     * @param id 房间资产关系ID
     * @return 房间资产关系
     */
    public BaseRoomAssets selectBaseRoomAssetsById(Long id);

    /**
     * 查询房间资产关系列表
     * 
     * @param baseRoomAssets 房间资产关系
     * @return 房间资产关系集合
     */
    public List<BaseRoomAssets> selectBaseRoomAssetsList(BaseRoomAssets baseRoomAssets);

    /**
     * 新增房间资产关系
     * 
     * @param baseRoomAssets 房间资产关系
     * @return 结果
     */
    public int insertBaseRoomAssets(BaseRoomAssets baseRoomAssets);

    /**
     * 修改房间资产关系
     * 
     * @param baseRoomAssets 房间资产关系
     * @return 结果
     */
    public int updateBaseRoomAssets(BaseRoomAssets baseRoomAssets);

    /**
     * 删除房间资产关系
     * 
     * @param id 房间资产关系ID
     * @return 结果
     */
    public int deleteBaseRoomAssetsById(Long id);

    /**
     * 批量删除房间资产关系
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteBaseRoomAssetsByIds(Long[] ids);
}
