package com.ruoyi.hostel.mapper;

import java.util.List;
import com.ruoyi.hostel.domain.BaseDormitoryLayer;

/**
 * 宿舍楼层档案Mapper接口
 * 
 * @author ruoyi
 * @date 2021-05-29
 */
public interface BaseDormitoryLayerMapper 
{
    /**
     * 查询宿舍楼层档案
     * 
     * @param id 宿舍楼层档案ID
     * @return 宿舍楼层档案
     */
    public BaseDormitoryLayer selectBaseDormitoryLayerById(Long id);

    /**
     * 查询宿舍楼层档案列表
     * 
     * @param baseDormitoryLayer 宿舍楼层档案
     * @return 宿舍楼层档案集合
     */
    public List<BaseDormitoryLayer> selectBaseDormitoryLayerList(BaseDormitoryLayer baseDormitoryLayer);

    /**
     * 新增宿舍楼层档案
     * 
     * @param baseDormitoryLayer 宿舍楼层档案
     * @return 结果
     */
    public int insertBaseDormitoryLayer(BaseDormitoryLayer baseDormitoryLayer);

    /**
     * 修改宿舍楼层档案
     * 
     * @param baseDormitoryLayer 宿舍楼层档案
     * @return 结果
     */
    public int updateBaseDormitoryLayer(BaseDormitoryLayer baseDormitoryLayer);

    /**
     * 删除宿舍楼层档案
     * 
     * @param id 宿舍楼层档案ID
     * @return 结果
     */
    public int deleteBaseDormitoryLayerById(Long id);

    /**
     * 批量删除宿舍楼层档案
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteBaseDormitoryLayerByIds(Long[] ids);
}
