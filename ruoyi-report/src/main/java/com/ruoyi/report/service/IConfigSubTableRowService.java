package com.ruoyi.report.service;

import java.util.List;
import com.ruoyi.report.domain.ConfigSubTableRow;

/**
 * 子行的配置
Service接口
 * 
 * @author ruoyi
 * @date 2021-05-03
 */
public interface IConfigSubTableRowService 
{
    /**
     * 查询子行的配置

     * 
     * @param id 子行的配置
ID
     * @return 子行的配置

     */
    public ConfigSubTableRow selectConfigSubTableRowById(Long id);

    /**
     * 查询子行的配置
列表
     * 
     * @param configSubTableRow 子行的配置

     * @return 子行的配置
集合
     */
    public List<ConfigSubTableRow> selectConfigSubTableRowList(ConfigSubTableRow configSubTableRow);

    /**
     * 新增子行的配置

     * 
     * @param configSubTableRow 子行的配置

     * @return 结果
     */
    public int insertConfigSubTableRow(ConfigSubTableRow configSubTableRow);

    /**
     * 修改子行的配置

     * 
     * @param configSubTableRow 子行的配置

     * @return 结果
     */
    public int updateConfigSubTableRow(ConfigSubTableRow configSubTableRow);

    /**
     * 批量删除子行的配置

     * 
     * @param ids 需要删除的子行的配置
ID
     * @return 结果
     */
    public int deleteConfigSubTableRowByIds(Long[] ids);

    /**
     * 删除子行的配置
信息
     * 
     * @param id 子行的配置
ID
     * @return 结果
     */
    public int deleteConfigSubTableRowById(Long id);
}
