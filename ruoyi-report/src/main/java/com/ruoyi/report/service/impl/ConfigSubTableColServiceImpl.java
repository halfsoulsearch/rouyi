package com.ruoyi.report.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.report.mapper.ConfigSubTableColMapper;
import com.ruoyi.report.domain.ConfigSubTableCol;
import com.ruoyi.report.service.IConfigSubTableColService;

/**
 * 子列的配置Service业务层处理
 * 
 * @author wzh
 * @date 2021-05-03
 */
@Service
public class ConfigSubTableColServiceImpl implements IConfigSubTableColService 
{
    @Autowired
    private ConfigSubTableColMapper configSubTableColMapper;

    /**
     * 查询子列的配置
     * 
     * @param id 子列的配置ID
     * @return 子列的配置
     */
    @Override
    public ConfigSubTableCol selectConfigSubTableColById(Long id)
    {
        return configSubTableColMapper.selectConfigSubTableColById(id);
    }

    /**
     * 查询子列的配置列表
     * 
     * @param configSubTableCol 子列的配置
     * @return 子列的配置
     */
    @Override
    public List<ConfigSubTableCol> selectConfigSubTableColList(ConfigSubTableCol configSubTableCol)
    {
        return configSubTableColMapper.selectConfigSubTableColList(configSubTableCol);
    }

    /**
     * 新增子列的配置
     * 
     * @param configSubTableCol 子列的配置
     * @return 结果
     */
    @Override
    public int insertConfigSubTableCol(ConfigSubTableCol configSubTableCol)
    {
        return configSubTableColMapper.insertConfigSubTableCol(configSubTableCol);
    }

    /**
     * 修改子列的配置
     * 
     * @param configSubTableCol 子列的配置
     * @return 结果
     */
    @Override
    public int updateConfigSubTableCol(ConfigSubTableCol configSubTableCol)
    {
        return configSubTableColMapper.updateConfigSubTableCol(configSubTableCol);
    }

    /**
     * 批量删除子列的配置
     * 
     * @param ids 需要删除的子列的配置ID
     * @return 结果
     */
    @Override
    public int deleteConfigSubTableColByIds(Long[] ids)
    {
        return configSubTableColMapper.deleteConfigSubTableColByIds(ids);
    }

    /**
     * 删除子列的配置信息
     * 
     * @param id 子列的配置ID
     * @return 结果
     */
    @Override
    public int deleteConfigSubTableColById(Long id)
    {
        return configSubTableColMapper.deleteConfigSubTableColById(id);
    }
}
