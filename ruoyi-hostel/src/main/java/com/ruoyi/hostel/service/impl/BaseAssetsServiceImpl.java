package com.ruoyi.hostel.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.hostel.mapper.BaseAssetsMapper;
import com.ruoyi.hostel.domain.BaseAssets;
import com.ruoyi.hostel.service.IBaseAssetsService;

/**
 * 资产档案Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-05-28
 */
@Service
public class BaseAssetsServiceImpl implements IBaseAssetsService 
{
    @Autowired
    private BaseAssetsMapper baseAssetsMapper;

    /**
     * 查询资产档案
     * 
     * @param id 资产档案ID
     * @return 资产档案
     */
    @Override
    public BaseAssets selectBaseAssetsById(Long id)
    {
        return baseAssetsMapper.selectBaseAssetsById(id);
    }

    /**
     * 查询资产档案列表
     * 
     * @param baseAssets 资产档案
     * @return 资产档案
     */
    @Override
    public List<BaseAssets> selectBaseAssetsList(BaseAssets baseAssets)
    {
        return baseAssetsMapper.selectBaseAssetsList(baseAssets);
    }

    /**
     * 新增资产档案
     * 
     * @param baseAssets 资产档案
     * @return 结果
     */
    @Override
    public int insertBaseAssets(BaseAssets baseAssets)
    {
        return baseAssetsMapper.insertBaseAssets(baseAssets);
    }

    /**
     * 修改资产档案
     * 
     * @param baseAssets 资产档案
     * @return 结果
     */
    @Override
    public int updateBaseAssets(BaseAssets baseAssets)
    {
        return baseAssetsMapper.updateBaseAssets(baseAssets);
    }

    /**
     * 批量删除资产档案
     * 
     * @param ids 需要删除的资产档案ID
     * @return 结果
     */
    @Override
    public int deleteBaseAssetsByIds(Long[] ids)
    {
        return baseAssetsMapper.deleteBaseAssetsByIds(ids);
    }

    /**
     * 删除资产档案信息
     * 
     * @param id 资产档案ID
     * @return 结果
     */
    @Override
    public int deleteBaseAssetsById(Long id)
    {
        return baseAssetsMapper.deleteBaseAssetsById(id);
    }
}
