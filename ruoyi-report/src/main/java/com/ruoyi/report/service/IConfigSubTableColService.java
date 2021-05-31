package com.ruoyi.report.service;

import java.util.List;
import com.ruoyi.report.domain.ConfigSubTableCol;

/**
 * 子列的配置Service接口
 * 
 * @author wzh
 * @date 2021-05-03
 */
public interface IConfigSubTableColService 
{
    /**
     * 查询子列的配置
     * 
     * @param id 子列的配置ID
     * @return 子列的配置
     */
    public ConfigSubTableCol selectConfigSubTableColById(Long id);

    /**
     * 查询子列的配置列表
     * 
     * @param configSubTableCol 子列的配置
     * @return 子列的配置集合
     */
    public List<ConfigSubTableCol> selectConfigSubTableColList(ConfigSubTableCol configSubTableCol);

    /**
     * 新增子列的配置
     * 
     * @param configSubTableCol 子列的配置
     * @return 结果
     */
    public int insertConfigSubTableCol(ConfigSubTableCol configSubTableCol);

    /**
     * 修改子列的配置
     * 
     * @param configSubTableCol 子列的配置
     * @return 结果
     */
    public int updateConfigSubTableCol(ConfigSubTableCol configSubTableCol);

    /**
     * 批量删除子列的配置
     * 
     * @param ids 需要删除的子列的配置ID
     * @return 结果
     */
    public int deleteConfigSubTableColByIds(Long[] ids);

    /**
     * 删除子列的配置信息
     * 
     * @param id 子列的配置ID
     * @return 结果
     */
    public int deleteConfigSubTableColById(Long id);
}
