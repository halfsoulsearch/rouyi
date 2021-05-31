package com.ruoyi.report.service;

import java.util.List;
import com.ruoyi.report.domain.ConfigShift;

/**
 * 班次Service接口
 * 
 * @author wzy
 * @date 2021-05-02
 */
public interface IConfigShiftService 
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
     * 批量删除班次
     * 
     * @param ids 需要删除的班次ID
     * @return 结果
     */
    public int deleteConfigShiftByIds(Long[] ids);

    /**
     * 删除班次信息
     * 
     * @param id 班次ID
     * @return 结果
     */
    public int deleteConfigShiftById(Long id);
}
