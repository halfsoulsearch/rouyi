package com.ruoyi.report.mapper;

import java.util.List;
import com.ruoyi.report.domain.ConfigShift;
import com.ruoyi.report.domain.ConfigMainTable;

/**
 * 班次Mapper接口
 * 
 * @author wzy
 * @date 2021-05-02
 */
public interface ConfigShiftMapper 
{
    /**
     * 查询班次
     * 
     * @param id 班次ID
     * @return 班次
     */
    public ConfigShift selectConfigShiftById(Long id);

    /**
     * 查询班次列表
     * 
     * @param configShift 班次
     * @return 班次集合
     */
    public List<ConfigShift> selectConfigShiftList(ConfigShift configShift);

    /**
     * 新增班次
     * 
     * @param configShift 班次
     * @return 结果
     */
    public int insertConfigShift(ConfigShift configShift);

    /**
     * 修改班次
     * 
     * @param configShift 班次
     * @return 结果
     */
    public int updateConfigShift(ConfigShift configShift);

    /**
     * 删除班次
     * 
     * @param id 班次ID
     * @return 结果
     */
    public int deleteConfigShiftById(Long id);

    /**
     * 批量删除班次
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteConfigShiftByIds(Long[] ids);

    /**
     * 批量删除主的配置
     * 
     * @param customerIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteConfigMainTableByIds(Long[] ids);
    
    /**
     * 批量新增主的配置
     * 
     * @param configMainTableList 主的配置列表
     * @return 结果
     */
    public int batchConfigMainTable(List<ConfigMainTable> configMainTableList);
    

    /**
     * 通过班次ID删除主的配置信息
     * 
     * @param roleId 角色ID
     * @return 结果
     */
    public int deleteConfigMainTableById(Long id);
}
