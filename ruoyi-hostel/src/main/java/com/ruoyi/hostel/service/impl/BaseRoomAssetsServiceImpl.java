package com.ruoyi.hostel.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.hostel.mapper.BaseRoomAssetsMapper;
import com.ruoyi.hostel.domain.BaseRoomAssets;
import com.ruoyi.hostel.service.IBaseRoomAssetsService;

/**
 * 房间资产关系Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-05-29
 */
@Service
public class BaseRoomAssetsServiceImpl implements IBaseRoomAssetsService 
{
    @Autowired
    private BaseRoomAssetsMapper baseRoomAssetsMapper;

    /**
     * 查询房间资产关系
     * 
     * @param id 房间资产关系ID
     * @return 房间资产关系
     */
    @Override
    public BaseRoomAssets selectBaseRoomAssetsById(Long id)
    {
        return baseRoomAssetsMapper.selectBaseRoomAssetsById(id);
    }

    /**
     * 查询房间资产关系列表
     * 
     * @param baseRoomAssets 房间资产关系
     * @return 房间资产关系
     */
    @Override
    public List<BaseRoomAssets> selectBaseRoomAssetsList(BaseRoomAssets baseRoomAssets)
    {
        return baseRoomAssetsMapper.selectBaseRoomAssetsList(baseRoomAssets);
    }

    /**
     * 新增房间资产关系
     * 
     * @param baseRoomAssets 房间资产关系
     * @return 结果
     */
    @Override
    public int insertBaseRoomAssets(BaseRoomAssets baseRoomAssets)
    {
        return baseRoomAssetsMapper.insertBaseRoomAssets(baseRoomAssets);
    }

    /**
     * 修改房间资产关系
     * 
     * @param baseRoomAssets 房间资产关系
     * @return 结果
     */
    @Override
    public int updateBaseRoomAssets(BaseRoomAssets baseRoomAssets)
    {
        return baseRoomAssetsMapper.updateBaseRoomAssets(baseRoomAssets);
    }

    /**
     * 批量删除房间资产关系
     * 
     * @param ids 需要删除的房间资产关系ID
     * @return 结果
     */
    @Override
    public int deleteBaseRoomAssetsByIds(Long[] ids)
    {
        return baseRoomAssetsMapper.deleteBaseRoomAssetsByIds(ids);
    }

    /**
     * 删除房间资产关系信息
     * 
     * @param id 房间资产关系ID
     * @return 结果
     */
    @Override
    public int deleteBaseRoomAssetsById(Long id)
    {
        return baseRoomAssetsMapper.deleteBaseRoomAssetsById(id);
    }
}
