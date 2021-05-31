package com.ruoyi.report.service;

import java.util.List;
import com.ruoyi.report.domain.ConfigMainTable;

/**
 * 主的配置Service接口
 * 
 * @author wzy
 * @date 2021-05-02
 */
public interface IConfigMainTableService 
{
    /**
     * 查询主的配置
     * 
     * @param id 主的配置ID
     * @return 主的配置
     */
    public ConfigMainTable selectConfigMainTableById(Long id);

    /**
     * 查询主的配置列表
     * 
     * @param configMainTable 主的配置
     * @return 主的配置集合
     */
    public List<ConfigMainTable> selectConfigMainTableList(ConfigMainTable configMainTable);

    /**
     * 新增主的配置
     * 
     * @param configMainTable 主的配置
     * @return 结果
     */
    public int insertConfigMainTable(ConfigMainTable configMainTable);

    /**
     * 修改主的配置
     * 
     * @param configMainTable 主的配置
     * @return 结果
     */
    public int updateConfigMainTable(ConfigMainTable configMainTable);

    /**
     * 批量删除主的配置
     * 
     * @param ids 需要删除的主的配置ID
     * @return 结果
     */
    public int deleteConfigMainTableByIds(Long[] ids);

    /**
     * 删除主的配置信息
     * 
     * @param id 主的配置ID
     * @return 结果
     */
    public int deleteConfigMainTableById(Long id);
}
