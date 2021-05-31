package com.ruoyi.report.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.report.mapper.ConfigMainTableMapper;
import com.ruoyi.report.domain.ConfigMainTable;
import com.ruoyi.report.service.IConfigMainTableService;

/**
 * 主的配置Service业务层处理
 * 
 * @author wzy
 * @date 2021-05-02
 */
@Service
public class ConfigMainTableServiceImpl implements IConfigMainTableService 
{
    @Autowired
    private ConfigMainTableMapper configMainTableMapper;

    /**
     * 查询主的配置
     * 
     * @param id 主的配置ID
     * @return 主的配置
     */
    @Override
    public ConfigMainTable selectConfigMainTableById(Long id)
    {
        return configMainTableMapper.selectConfigMainTableById(id);
    }

    /**
     * 查询主的配置列表
     * 
     * @param configMainTable 主的配置
     * @return 主的配置
     */
    @Override
    public List<ConfigMainTable> selectConfigMainTableList(ConfigMainTable configMainTable)
    {
        return configMainTableMapper.selectConfigMainTableList(configMainTable);
    }

    /**
     * 新增主的配置
     * 
     * @param configMainTable 主的配置
     * @return 结果
     */
    @Override
    public int insertConfigMainTable(ConfigMainTable configMainTable)
    {
        return configMainTableMapper.insertConfigMainTable(configMainTable);
    }

    /**
     * 修改主的配置
     * 
     * @param configMainTable 主的配置
     * @return 结果
     */
    @Override
    public int updateConfigMainTable(ConfigMainTable configMainTable)
    {
        return configMainTableMapper.updateConfigMainTable(configMainTable);
    }

    /**
     * 批量删除主的配置
     * 
     * @param ids 需要删除的主的配置ID
     * @return 结果
     */
    @Override
    public int deleteConfigMainTableByIds(Long[] ids)
    {
        return configMainTableMapper.deleteConfigMainTableByIds(ids);
    }

    /**
     * 删除主的配置信息
     * 
     * @param id 主的配置ID
     * @return 结果
     */
    @Override
    public int deleteConfigMainTableById(Long id)
    {
        return configMainTableMapper.deleteConfigMainTableById(id);
    }
}
