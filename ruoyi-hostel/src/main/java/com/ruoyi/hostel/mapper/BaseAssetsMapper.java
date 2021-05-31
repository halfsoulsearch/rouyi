package com.ruoyi.hostel.mapper;

import java.util.List;
import com.ruoyi.hostel.domain.BaseAssets;

/**
 * 资产档案Mapper接口
 * 
 * @author ruoyi
 * @date 2021-05-28
 */
public interface BaseAssetsMapper 
{
    /**
     * 查询资产档案
     * 
     * @param id 资产档案ID
     * @return 资产档案
     */
    public BaseAssets selectBaseAssetsById(Long id);

    /**
     * 查询资产档案列表
     * 
     * @param baseAssets 资产档案
     * @return 资产档案集合
     */
    public List<BaseAssets> selectBaseAssetsList(BaseAssets baseAssets);

    /**
     * 新增资产档案
     * 
     * @param baseAssets 资产档案
     * @return 结果
     */
    public int insertBaseAssets(BaseAssets baseAssets);

    /**
     * 修改资产档案
     * 
     * @param baseAssets 资产档案
     * @return 结果
     */
    public int updateBaseAssets(BaseAssets baseAssets);

    /**
     * 删除资产档案
     * 
     * @param id 资产档案ID
     * @return 结果
     */
    public int deleteBaseAssetsById(Long id);

    /**
     * 批量删除资产档案
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteBaseAssetsByIds(Long[] ids);
}
