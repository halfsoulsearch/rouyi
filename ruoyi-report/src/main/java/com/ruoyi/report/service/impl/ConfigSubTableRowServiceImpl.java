package com.ruoyi.report.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.report.mapper.ConfigSubTableRowMapper;
import com.ruoyi.report.domain.ConfigSubTableRow;
import com.ruoyi.report.service.IConfigSubTableRowService;

/**
 * 子行的配置
Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-05-03
 */
@Service
public class ConfigSubTableRowServiceImpl implements IConfigSubTableRowService 
{
    @Autowired
    private ConfigSubTableRowMapper configSubTableRowMapper;

    /**
     * 查询子行的配置

     * 
     * @param id 子行的配置
ID
     * @return 子行的配置

     */
    @Override
    public ConfigSubTableRow selectConfigSubTableRowById(Long id)
    {
        return configSubTableRowMapper.selectConfigSubTableRowById(id);
    }

    /**
     * 查询子行的配置
列表
     * 
     * @param configSubTableRow 子行的配置

     * @return 子行的配置

     */
    @Override
    public List<ConfigSubTableRow> selectConfigSubTableRowList(ConfigSubTableRow configSubTableRow)
    {
        return configSubTableRowMapper.selectConfigSubTableRowList(configSubTableRow);
    }

    /**
     * 新增子行的配置

     * 
     * @param configSubTableRow 子行的配置

     * @return 结果
     */
    @Override
    public int insertConfigSubTableRow(ConfigSubTableRow configSubTableRow)
    {
        return configSubTableRowMapper.insertConfigSubTableRow(configSubTableRow);
    }

    /**
     * 修改子行的配置

     * 
     * @param configSubTableRow 子行的配置

     * @return 结果
     */
    @Override
    public int updateConfigSubTableRow(ConfigSubTableRow configSubTableRow)
    {
        return configSubTableRowMapper.updateConfigSubTableRow(configSubTableRow);
    }

    /**
     * 批量删除子行的配置

     * 
     * @param ids 需要删除的子行的配置
ID
     * @return 结果
     */
    @Override
    public int deleteConfigSubTableRowByIds(Long[] ids)
    {
        return configSubTableRowMapper.deleteConfigSubTableRowByIds(ids);
    }

    /**
     * 删除子行的配置
信息
     * 
     * @param id 子行的配置
ID
     * @return 结果
     */
    @Override
    public int deleteConfigSubTableRowById(Long id)
    {
        return configSubTableRowMapper.deleteConfigSubTableRowById(id);
    }
}
