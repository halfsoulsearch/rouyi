package com.ruoyi.report.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.report.mapper.ConfigSubTableMapper;
import com.ruoyi.report.domain.ConfigSubTable;
import com.ruoyi.report.service.IConfigSubTableService;

/**
 * 子的配置Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-05-03
 */
@Service
public class ConfigSubTableServiceImpl implements IConfigSubTableService 
{
    @Autowired
    private ConfigSubTableMapper configSubTableMapper;

    /**
     * 查询子的配置
     * 
     * @param id 子的配置ID
     * @return 子的配置
     */
    @Override
    public ConfigSubTable selectConfigSubTableById(Long id)
    {
        return configSubTableMapper.selectConfigSubTableById(id);
    }

    /**
     * 查询子的配置列表
     * 
     * @param configSubTable 子的配置
     * @return 子的配置
     */
    @Override
    public List<ConfigSubTable> selectConfigSubTableList(ConfigSubTable configSubTable)
    {
        return configSubTableMapper.selectConfigSubTableList(configSubTable);
    }

    /**
     * 新增子的配置
     * 
     * @param configSubTable 子的配置
     * @return 结果
     */
    @Override
    public int insertConfigSubTable(ConfigSubTable configSubTable)
    {
        return configSubTableMapper.insertConfigSubTable(configSubTable);
    }

    /**
     * 修改子的配置
     * 
     * @param configSubTable 子的配置
     * @return 结果
     */
    @Override
    public int updateConfigSubTable(ConfigSubTable configSubTable)
    {
        return configSubTableMapper.updateConfigSubTable(configSubTable);
    }

    /**
     * 批量删除子的配置
     * 
     * @param ids 需要删除的子的配置ID
     * @return 结果
     */
    @Override
    public int deleteConfigSubTableByIds(Long[] ids)
    {
        return configSubTableMapper.deleteConfigSubTableByIds(ids);
    }

    /**
     * 删除子的配置信息
     * 
     * @param id 子的配置ID
     * @return 结果
     */
    @Override
    public int deleteConfigSubTableById(Long id)
    {
        return configSubTableMapper.deleteConfigSubTableById(id);
    }
}
