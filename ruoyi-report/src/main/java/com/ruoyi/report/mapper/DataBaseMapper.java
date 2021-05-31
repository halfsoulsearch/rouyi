package com.ruoyi.report.mapper;

import java.util.List;
import com.ruoyi.report.domain.DataBase;

/**
 * 主基础数据信息
Mapper接口
 * 
 * @author ruoyi
 * @date 2021-05-03
 */
public interface DataBaseMapper 
{
    /**
     * 查询主基础数据信息

     * 
     * @param id 主基础数据信息
    ID
     * @return 主基础数据信息

     */
    public DataBase selectDataBaseById(Long id);

    /**
     * 查询主基础数据信息
列表
     * 
     * @param dataBase 主基础数据信息

     * @return 主基础数据信息
集合
     */
    public List<DataBase> selectDataBaseList(DataBase dataBase);

    /**
     * 新增主基础数据信息

     * 
     * @param dataBase 主基础数据信息

     * @return 结果
     */
    public int insertDataBase(DataBase dataBase);

    /**
     * 修改主基础数据信息

     * 
     * @param dataBase 主基础数据信息

     * @return 结果
     */
    public int updateDataBase(DataBase dataBase);

    /**
     * 删除主基础数据信息

     * 
     * @param id 主基础数据信息
ID
     * @return 结果
     */
    public int deleteDataBaseById(Long id);

    /**
     * 批量删除主基础数据信息

     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteDataBaseByIds(Long[] ids);
}
