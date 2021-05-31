package com.ruoyi.report.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.report.mapper.DataBaseMapper;
import com.ruoyi.report.domain.DataBase;
import com.ruoyi.report.service.IDataBaseService;

/**
 * 主基础数据信息
Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-05-03
 */
@Service
public class DataBaseServiceImpl implements IDataBaseService 
{
    @Autowired
    private DataBaseMapper dataBaseMapper;

    /**
     * 查询主基础数据信息

     * 
     * @param id 主基础数据信息
ID
     * @return 主基础数据信息

     */
    @Override
    public DataBase selectDataBaseById(Long id)
    {
        return dataBaseMapper.selectDataBaseById(id);
    }

    /**
     * 查询主基础数据信息
列表
     * 
     * @param dataBase 主基础数据信息

     * @return 主基础数据信息

     */
    @Override
    public List<DataBase> selectDataBaseList(DataBase dataBase)
    {
        return dataBaseMapper.selectDataBaseList(dataBase);
    }

    /**
     * 新增主基础数据信息

     * 
     * @param dataBase 主基础数据信息

     * @return 结果
     */
    @Override
    public int insertDataBase(DataBase dataBase)
    {
        dataBase.setCreateTime(DateUtils.getNowDate());
        return dataBaseMapper.insertDataBase(dataBase);
    }

    /**
     * 修改主基础数据信息

     * 
     * @param dataBase 主基础数据信息

     * @return 结果
     */
    @Override
    public int updateDataBase(DataBase dataBase)
    {
        dataBase.setUpdateTime(DateUtils.getNowDate());
        return dataBaseMapper.updateDataBase(dataBase);
    }

    /**
     * 批量删除主基础数据信息

     * 
     * @param ids 需要删除的主基础数据信息
ID
     * @return 结果
     */
    @Override
    public int deleteDataBaseByIds(Long[] ids)
    {
        return dataBaseMapper.deleteDataBaseByIds(ids);
    }

    /**
     * 删除主基础数据信息
信息
     * 
     * @param id 主基础数据信息
ID
     * @return 结果
     */
    @Override
    public int deleteDataBaseById(Long id)
    {
        return dataBaseMapper.deleteDataBaseById(id);
    }
}
