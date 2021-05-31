package com.ruoyi.report.mapper;

import com.ruoyi.report.domain.ConfigIgnoreShift;

import java.util.List;

/**
 * 忽略班次的数据Mapper接口
 *
 * @author ruoyi
 * @date 2021-05-08
 */
public interface ConfigIgnoreShiftMapper {
    /**
     * 查询忽略班次的数据
     *
     * @param id 忽略班次的数据ID
     * @return 忽略班次的数据
     */
    public ConfigIgnoreShift selectConfigIgnoreShiftById(Long id);

    /**
     * 查询忽略班次的数据列表
     *
     * @param configIgnoreShift 忽略班次的数据
     * @return 忽略班次的数据集合
     */
    public List<ConfigIgnoreShift> selectConfigIgnoreShiftList(ConfigIgnoreShift configIgnoreShift);

    /**
     * 新增忽略班次的数据
     *
     * @param configIgnoreShift 忽略班次的数据
     * @return 结果
     */
    public int insertConfigIgnoreShift(ConfigIgnoreShift configIgnoreShift);

    /**
     * 修改忽略班次的数据
     *
     * @param configIgnoreShift 忽略班次的数据
     * @return 结果
     */
    public int updateConfigIgnoreShift(ConfigIgnoreShift configIgnoreShift);

    /**
     * 删除忽略班次的数据
     *
     * @param id 忽略班次的数据ID
     * @return 结果
     */
    public int deleteConfigIgnoreShiftById(Long id);

    /**
     * 批量删除忽略班次的数据
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteConfigIgnoreShiftByIds(Long[] ids);
}
