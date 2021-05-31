package com.ruoyi.report.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import com.ruoyi.common.utils.StringUtils;
import org.springframework.transaction.annotation.Transactional;
import com.ruoyi.report.domain.ConfigMainTable;
import com.ruoyi.report.mapper.ConfigShiftMapper;
import com.ruoyi.report.domain.ConfigShift;
import com.ruoyi.report.service.IConfigShiftService;

/**
 * 班次Service业务层处理
 * 
 * @author wzy
 * @date 2021-05-02
 */
@Service
public class ConfigShiftServiceImpl implements IConfigShiftService 
{
    @Autowired
    private ConfigShiftMapper configShiftMapper;

    /**
     * 查询班次
     * 
     * @param id 班次ID
     * @return 班次
     */
    @Override
    public ConfigShift selectConfigShiftById(Long id)
    {
        return configShiftMapper.selectConfigShiftById(id);
    }

    /**
     * 查询班次列表
     * 
     * @param configShift 班次
     * @return 班次
     */
    @Override
    public List<ConfigShift> selectConfigShiftList(ConfigShift configShift)
    {
        return configShiftMapper.selectConfigShiftList(configShift);
    }

    /**
     * 新增班次
     * 
     * @param configShift 班次
     * @return 结果
     */
    @Transactional
    @Override
    public int insertConfigShift(ConfigShift configShift)
    {
        int rows = configShiftMapper.insertConfigShift(configShift);
        insertConfigMainTable(configShift);
        return rows;
    }

    /**
     * 修改班次
     * 
     * @param configShift 班次
     * @return 结果
     */
    @Transactional
    @Override
    public int updateConfigShift(ConfigShift configShift)
    {
        configShiftMapper.deleteConfigMainTableById(configShift.getId());
        insertConfigMainTable(configShift);
        return configShiftMapper.updateConfigShift(configShift);
    }

    /**
     * 批量删除班次
     * 
     * @param ids 需要删除的班次ID
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteConfigShiftByIds(Long[] ids)
    {
        configShiftMapper.deleteConfigMainTableByIds(ids);
        return configShiftMapper.deleteConfigShiftByIds(ids);
    }

    /**
     * 删除班次信息
     * 
     * @param id 班次ID
     * @return 结果
     */
    @Override
    public int deleteConfigShiftById(Long id)
    {
        configShiftMapper.deleteConfigMainTableById(id);
        return configShiftMapper.deleteConfigShiftById(id);
    }

    /**
     * 新增主的配置信息
     * 
     * @param configShift 班次对象
     */
    public void insertConfigMainTable(ConfigShift configShift)
    {
        List<ConfigMainTable> configMainTableList = configShift.getConfigMainTableList();
        Long id = configShift.getId();
        if (StringUtils.isNotNull(configMainTableList))
        {
            List<ConfigMainTable> list = new ArrayList<ConfigMainTable>();
            for (ConfigMainTable configMainTable : configMainTableList)
            {
                configMainTable.setId(id);
                list.add(configMainTable);
            }
            if (list.size() > 0)
            {
                configShiftMapper.batchConfigMainTable(list);
            }
        }
    }
}
