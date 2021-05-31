package com.ruoyi.report.mapper;

import java.util.List;
import com.ruoyi.report.domain.ConfigSubTable;

/**
 * 子的配置Mapper接口
 * 
 * @author ruoyi
 * @date 2021-05-03
 */
public interface ConfigSubTableMapper 
{
    /**
     * 查询子的配置
     * 
     * @param id 子的配置ID
     * @return 子的配置
     */
    public ConfigSubTable selectConfigSubTableById(Long id);

    /**
     * 查询子的配置列表
     * 
     * @param configSubTable 子的配置
     * @return 子的配置集合
     */
    public List<ConfigSubTable> selectConfigSubTableList(ConfigSubTable configSubTable);

    /**
     * 新增子的配置
     * 
     * @param configSubTable 子的配置
     * @return 结果
     */
    public int insertConfigSubTable(ConfigSubTable configSubTable);

    /**
     * 修改子的配置
     * 
     * @param configSubTable 子的配置
     * @return 结果
     */
    public int updateConfigSubTable(ConfigSubTable configSubTable);

    /**
     * 删除子的配置
     * 
     * @param id 子的配置ID
     * @return 结果
     */
    public int deleteConfigSubTableById(Long id);

    /**
     * 批量删除子的配置
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteConfigSubTableByIds(Long[] ids);
}
