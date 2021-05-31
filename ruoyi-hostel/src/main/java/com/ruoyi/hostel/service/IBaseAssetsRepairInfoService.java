package com.ruoyi.hostel.service;

import java.util.List;
import com.ruoyi.hostel.domain.BaseAssetsRepairInfo;
import com.ruoyi.hostel.domain.vo.SearchBaseAssetsRepairInfoVO;

/**
 * 资产维修记录Service接口
 * 
 * @author ruoyi
 * @date 2021-05-29
 */
public interface IBaseAssetsRepairInfoService 
{
    /**
     * 查询资产维修记录
     * 
     * @param id 资产维修记录ID
     * @return 资产维修记录
     */
    public BaseAssetsRepairInfo selectBaseAssetsRepairInfoById(Long id);

    /**
     * 查询资产维修记录列表
     * 
     * @param baseAssetsRepairInfo 资产维修记录
     * @return 资产维修记录集合
     */
    public List<BaseAssetsRepairInfo> selectBaseAssetsRepairInfoList(BaseAssetsRepairInfo baseAssetsRepairInfo);


    /**
     * 根据资产id维修记录
     * @param assetsId
     * @return
     */
    List<SearchBaseAssetsRepairInfoVO> getRepairInfoPage(Long assetsId);


    /**
     * 新增资产维修记录
     * 
     * @param baseAssetsRepairInfo 资产维修记录
     * @return 结果
     */
    public int insertBaseAssetsRepairInfo(BaseAssetsRepairInfo baseAssetsRepairInfo);

    /**
     * 修改资产维修记录
     * 
     * @param baseAssetsRepairInfo 资产维修记录
     * @return 结果
     */
    public int updateBaseAssetsRepairInfo(BaseAssetsRepairInfo baseAssetsRepairInfo);

    /**
     * 批量删除资产维修记录
     * 
     * @param ids 需要删除的资产维修记录ID
     * @return 结果
     */
    public int deleteBaseAssetsRepairInfoByIds(Long[] ids);

    /**
     * 删除资产维修记录信息
     * 
     * @param id 资产维修记录ID
     * @return 结果
     */
    public int deleteBaseAssetsRepairInfoById(Long id);
}
