package com.ruoyi.hostel.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.hostel.mapper.BaseTypeGroupMapper;
import com.ruoyi.hostel.domain.BaseTypeGroup;
import com.ruoyi.hostel.service.IBaseTypeGroupService;

/**
 * 类型组Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-05-29
 */
@Service
public class BaseTypeGroupServiceImpl implements IBaseTypeGroupService 
{
    @Autowired
    private BaseTypeGroupMapper baseTypeGroupMapper;

    /**
     * 查询类型组
     * 
     * @param baseTypeId 类型组ID
     * @return 类型组
     */
    @Override
    public BaseTypeGroup selectBaseTypeGroupById(Long baseTypeId)
    {
        return baseTypeGroupMapper.selectBaseTypeGroupById(baseTypeId);
    }

    /**
     * 查询类型组列表
     * 
     * @param baseTypeGroup 类型组
     * @return 类型组
     */
    @Override
    public List<BaseTypeGroup> selectBaseTypeGroupList(BaseTypeGroup baseTypeGroup)
    {
        return baseTypeGroupMapper.selectBaseTypeGroupList(baseTypeGroup);
    }

    /**
     * 新增类型组
     * 
     * @param baseTypeGroup 类型组
     * @return 结果
     */
    @Override
    public int insertBaseTypeGroup(BaseTypeGroup baseTypeGroup)
    {
        baseTypeGroup.setCreateTime(DateUtils.getNowDate());
        return baseTypeGroupMapper.insertBaseTypeGroup(baseTypeGroup);
    }

    /**
     * 修改类型组
     * 
     * @param baseTypeGroup 类型组
     * @return 结果
     */
    @Override
    public int updateBaseTypeGroup(BaseTypeGroup baseTypeGroup)
    {
        baseTypeGroup.setUpdateTime(DateUtils.getNowDate());
        return baseTypeGroupMapper.updateBaseTypeGroup(baseTypeGroup);
    }

    /**
     * 批量删除类型组
     * 
     * @param baseTypeIds 需要删除的类型组ID
     * @return 结果
     */
    @Override
    public int deleteBaseTypeGroupByIds(Long[] baseTypeIds)
    {
        return baseTypeGroupMapper.deleteBaseTypeGroupByIds(baseTypeIds);
    }

    /**
     * 删除类型组信息
     * 
     * @param baseTypeId 类型组ID
     * @return 结果
     */
    @Override
    public int deleteBaseTypeGroupById(Long baseTypeId)
    {
        return baseTypeGroupMapper.deleteBaseTypeGroupById(baseTypeId);
    }
}
