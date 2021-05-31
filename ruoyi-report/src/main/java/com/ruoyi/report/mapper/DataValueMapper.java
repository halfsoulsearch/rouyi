package com.ruoyi.report.mapper;

import java.util.List;
import com.ruoyi.report.domain.DataValue;

/**
 * 具体数据Mapper接口
 * 
 * @author wzh
 * @date 2021-05-03
 */
public interface DataValueMapper 
{
    /**
     * 查询具体数据
     * 
     * @param id 具体数据ID
     * @return 具体数据
     */
    public DataValue selectDataValueById(Long id);

    /**
     * 查询具体数据列表
     * 
     * @param dataValue 具体数据
     * @return 具体数据集合
     */
    public List<DataValue> selectDataValueList(DataValue dataValue);

    /**
     * 新增具体数据
     * 
     * @param dataValue 具体数据
     * @return 结果
     */
    public int insertDataValue(DataValue dataValue);

    /**
     * 修改具体数据
     * 
     * @param dataValue 具体数据
     * @return 结果
     */
    public int updateDataValue(DataValue dataValue);

    /**
     * 删除具体数据
     * 
     * @param id 具体数据ID
     * @return 结果
     */
    public int deleteDataValueById(Long id);

    /**
     * 批量删除具体数据
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteDataValueByIds(Long[] ids);
}
