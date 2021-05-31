package com.ruoyi.hostel.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.hostel.mapper.BaseDormitoryLayerMapper;
import com.ruoyi.hostel.domain.BaseDormitoryLayer;
import com.ruoyi.hostel.service.IBaseDormitoryLayerService;

/**
 * 宿舍楼层档案Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-05-29
 */
@Service
public class BaseDormitoryLayerServiceImpl implements IBaseDormitoryLayerService 
{
    @Autowired
    private BaseDormitoryLayerMapper baseDormitoryLayerMapper;

    /**
     * 查询宿舍楼层档案
     * 
     * @param id 宿舍楼层档案ID
     * @return 宿舍楼层档案
     */
    @Override
    public BaseDormitoryLayer selectBaseDormitoryLayerById(Long id)
    {
        return baseDormitoryLayerMapper.selectBaseDormitoryLayerById(id);
    }

    /**
     * 查询宿舍楼层档案列表
     * 
     * @param baseDormitoryLayer 宿舍楼层档案
     * @return 宿舍楼层档案
     */
    @Override
    public List<BaseDormitoryLayer> selectBaseDormitoryLayerList(BaseDormitoryLayer baseDormitoryLayer)
    {
        return baseDormitoryLayerMapper.selectBaseDormitoryLayerList(baseDormitoryLayer);
    }

    /**
     * 新增宿舍楼层档案
     * 
     * @param baseDormitoryLayer 宿舍楼层档案
     * @return 结果
     */
    @Override
    public int insertBaseDormitoryLayer(BaseDormitoryLayer baseDormitoryLayer)
    {
        return baseDormitoryLayerMapper.insertBaseDormitoryLayer(baseDormitoryLayer);
    }

    /**
     * 修改宿舍楼层档案
     * 
     * @param baseDormitoryLayer 宿舍楼层档案
     * @return 结果
     */
    @Override
    public int updateBaseDormitoryLayer(BaseDormitoryLayer baseDormitoryLayer)
    {
        return baseDormitoryLayerMapper.updateBaseDormitoryLayer(baseDormitoryLayer);
    }

    /**
     * 批量删除宿舍楼层档案
     * 
     * @param ids 需要删除的宿舍楼层档案ID
     * @return 结果
     */
    @Override
    public int deleteBaseDormitoryLayerByIds(Long[] ids)
    {
        return baseDormitoryLayerMapper.deleteBaseDormitoryLayerByIds(ids);
    }

    /**
     * 删除宿舍楼层档案信息
     * 
     * @param id 宿舍楼层档案ID
     * @return 结果
     */
    @Override
    public int deleteBaseDormitoryLayerById(Long id)
    {
        return baseDormitoryLayerMapper.deleteBaseDormitoryLayerById(id);
    }
}
