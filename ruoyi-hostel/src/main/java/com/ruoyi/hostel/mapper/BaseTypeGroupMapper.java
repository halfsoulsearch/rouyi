package com.ruoyi.hostel.mapper;

import java.util.List;
import com.ruoyi.hostel.domain.BaseTypeGroup;

/**
 * 类型组Mapper接口
 * 
 * @author ruoyi
 * @date 2021-05-29
 */
public interface BaseTypeGroupMapper 
{
    /**
     * 查询类型组
     * 
     * @param baseTypeId 类型组ID
     * @return 类型组
     */
    public BaseTypeGroup selectBaseTypeGroupById(Long baseTypeId);

    /**
     * 查询类型组列表
     * 
     * @param baseTypeGroup 类型组
     * @return 类型组集合
     */
    public List<BaseTypeGroup> selectBaseTypeGroupList(BaseTypeGroup baseTypeGroup);

    /**
     * 新增类型组
     * 
     * @param baseTypeGroup 类型组
     * @return 结果
     */
    public int insertBaseTypeGroup(BaseTypeGroup baseTypeGroup);

    /**
     * 修改类型组
     * 
     * @param baseTypeGroup 类型组
     * @return 结果
     */
    public int updateBaseTypeGroup(BaseTypeGroup baseTypeGroup);

    /**
     * 删除类型组
     * 
     * @param baseTypeId 类型组ID
     * @return 结果
     */
    public int deleteBaseTypeGroupById(Long baseTypeId);

    /**
     * 批量删除类型组
     * 
     * @param baseTypeIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteBaseTypeGroupByIds(Long[] baseTypeIds);
}
