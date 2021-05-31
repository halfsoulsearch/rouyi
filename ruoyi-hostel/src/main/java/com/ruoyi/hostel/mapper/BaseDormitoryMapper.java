package com.ruoyi.hostel.mapper;

import java.util.List;
import com.ruoyi.hostel.domain.BaseDormitory;

/**
 * 宿舍楼档案Mapper接口
 * 
 * @author lfx
 * @date 2021-05-28
 */
public interface BaseDormitoryMapper 
{
    /**
     * 查询宿舍楼档案
     * 
     * @param id 宿舍楼档案ID
     * @return 宿舍楼档案
     */
    public BaseDormitory selectBaseDormitoryById(Long id);

    /**
     * 查询宿舍楼档案列表
     * 
     * @param baseDormitory 宿舍楼档案
     * @return 宿舍楼档案集合
     */
    public List<BaseDormitory> selectBaseDormitoryList(BaseDormitory baseDormitory);

    /**
     * 新增宿舍楼档案
     * 
     * @param baseDormitory 宿舍楼档案
     * @return 结果
     */
    public int insertBaseDormitory(BaseDormitory baseDormitory);

    /**
     * 修改宿舍楼档案
     * 
     * @param baseDormitory 宿舍楼档案
     * @return 结果
     */
    public int updateBaseDormitory(BaseDormitory baseDormitory);

    /**
     * 删除宿舍楼档案
     * 
     * @param id 宿舍楼档案ID
     * @return 结果
     */
    public int deleteBaseDormitoryById(Long id);

    /**
     * 批量删除宿舍楼档案
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteBaseDormitoryByIds(Long[] ids);
}
