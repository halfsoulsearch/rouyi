package com.ruoyi.report.mapper;

import java.util.List;
import com.ruoyi.report.domain.ConfigMainTable;

/**
 * 主的配置Mapper接口
 * 
 * @author llt
 * @date 2021-05-03
 */
public interface ConfigMainTableMapper 
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
     * 删除主的配置
     * 
     * @param id 主的配置ID
     * @return 结果
     */
    public int deleteConfigMainTableById(Long id);

    /**
     * 批量删除主的配置
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteConfigMainTableByIds(Long[] ids);
}
