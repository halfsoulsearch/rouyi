package com.ruoyi.report.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.report.mapper.DataValueMapper;
import com.ruoyi.report.domain.DataValue;
import com.ruoyi.report.service.IDataValueService;

/**
 * 具体数据Service业务层处理
 * 
 * @author wzh
 * @date 2021-05-03
 */
@Service
public class DataValueServiceImpl implements IDataValueService 
{
    @Autowired
    private DataValueMapper dataValueMapper;

    /**
     * 查询具体数据
     * 
     * @param id 具体数据ID
     * @return 具体数据
     */
    @Override
    public DataValue selectDataValueById(Long id)
    {
        return dataValueMapper.selectDataValueById(id);
    }

    /**
     * 查询具体数据列表
     * 
     * @param dataValue 具体数据
     * @return 具体数据
     */
    @Override
    public List<DataValue> selectDataValueList(DataValue dataValue)
    {
        return dataValueMapper.selectDataValueList(dataValue);
    }

    /**
     * 新增具体数据
     * 
     * @param dataValue 具体数据
     * @return 结果
     */
    @Override
    public int insertDataValue(DataValue dataValue)
    {
        return dataValueMapper.insertDataValue(dataValue);
    }

    /**
     * 修改具体数据
     * 
     * @param dataValue 具体数据
     * @return 结果
     */
    @Override
    public int updateDataValue(DataValue dataValue)
    {
        return dataValueMapper.updateDataValue(dataValue);
    }

    /**
     * 批量删除具体数据
     * 
     * @param ids 需要删除的具体数据ID
     * @return 结果
     */
    @Override
    public int deleteDataValueByIds(Long[] ids)
    {
        return dataValueMapper.deleteDataValueByIds(ids);
    }

    /**
     * 删除具体数据信息
     * 
     * @param id 具体数据ID
     * @return 结果
     */
    @Override
    public int deleteDataValueById(Long id)
    {
        return dataValueMapper.deleteDataValueById(id);
    }
}
