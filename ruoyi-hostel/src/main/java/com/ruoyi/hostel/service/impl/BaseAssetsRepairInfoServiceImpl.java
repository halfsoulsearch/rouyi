package com.ruoyi.hostel.service.impl;

import java.util.List;

import com.ruoyi.hostel.domain.vo.SearchBaseAssetsRepairInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.hostel.mapper.BaseAssetsRepairInfoMapper;
import com.ruoyi.hostel.domain.BaseAssetsRepairInfo;
import com.ruoyi.hostel.service.IBaseAssetsRepairInfoService;

/**
 * 资产维修记录Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-05-29
 */
@Service
public class BaseAssetsRepairInfoServiceImpl implements IBaseAssetsRepairInfoService 
{
    @Autowired
    private BaseAssetsRepairInfoMapper baseAssetsRepairInfoMapper;

    /**
     * 查询资产维修记录
     * 
     * @param id 资产维修记录ID
     * @return 资产维修记录
     */
    @Override
    public BaseAssetsRepairInfo selectBaseAssetsRepairInfoById(Long id)
    {
        return baseAssetsRepairInfoMapper.selectBaseAssetsRepairInfoById(id);
    }

    /**
     * 查询资产维修记录列表
     * 
     * @param baseAssetsRepairInfo 资产维修记录
     * @return 资产维修记录
     */
    @Override
    public List<BaseAssetsRepairInfo> selectBaseAssetsRepairInfoList(BaseAssetsRepairInfo baseAssetsRepairInfo)
    {
        return baseAssetsRepairInfoMapper.selectBaseAssetsRepairInfoList(baseAssetsRepairInfo);
    }


    /**
     * 根据资产id维修记录
     * @param assetsId
     * @return
     */
    @Override
    public List<SearchBaseAssetsRepairInfoVO> getRepairInfoPage(Long assetsId) {
        return baseAssetsRepairInfoMapper.getRepairInfoPage(assetsId);
    }

    /**
     * 新增资产维修记录
     * 
     * @param baseAssetsRepairInfo 资产维修记录
     * @return 结果
     */
    @Override
    public int insertBaseAssetsRepairInfo(BaseAssetsRepairInfo baseAssetsRepairInfo)
    {
        return baseAssetsRepairInfoMapper.insertBaseAssetsRepairInfo(baseAssetsRepairInfo);
    }

    /**
     * 修改资产维修记录
     * 
     * @param baseAssetsRepairInfo 资产维修记录
     * @return 结果
     */
    @Override
    public int updateBaseAssetsRepairInfo(BaseAssetsRepairInfo baseAssetsRepairInfo)
    {
        return baseAssetsRepairInfoMapper.updateBaseAssetsRepairInfo(baseAssetsRepairInfo);
    }

    /**
     * 批量删除资产维修记录
     * 
     * @param ids 需要删除的资产维修记录ID
     * @return 结果
     */
    @Override
    public int deleteBaseAssetsRepairInfoByIds(Long[] ids)
    {
        return baseAssetsRepairInfoMapper.deleteBaseAssetsRepairInfoByIds(ids);
    }

    /**
     * 删除资产维修记录信息
     * 
     * @param id 资产维修记录ID
     * @return 结果
     */
    @Override
    public int deleteBaseAssetsRepairInfoById(Long id)
    {
        return baseAssetsRepairInfoMapper.deleteBaseAssetsRepairInfoById(id);
    }
}
