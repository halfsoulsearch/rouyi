package com.ruoyi.hostel.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.hostel.mapper.BaseDormitoryMapper;
import com.ruoyi.hostel.domain.BaseDormitory;
import com.ruoyi.hostel.service.IBaseDormitoryService;

/**
 * 宿舍楼档案Service业务层处理
 * 
 * @author lfx
 * @date 2021-05-28
 */
@Service
public class BaseDormitoryServiceImpl implements IBaseDormitoryService 
{
    @Autowired
    private BaseDormitoryMapper baseDormitoryMapper;

    /**
     * 查询宿舍楼档案
     * 
     * @param id 宿舍楼档案ID
     * @return 宿舍楼档案
     */
    @Override
    public BaseDormitory selectBaseDormitoryById(Long id)
    {
        return baseDormitoryMapper.selectBaseDormitoryById(id);
    }

    /**
     * 查询宿舍楼档案列表
     * 
     * @param baseDormitory 宿舍楼档案
     * @return 宿舍楼档案
     */
    @Override
    public List<BaseDormitory> selectBaseDormitoryList(BaseDormitory baseDormitory)
    {
        return baseDormitoryMapper.selectBaseDormitoryList(baseDormitory);
    }

    /**
     * 新增宿舍楼档案
     * 
     * @param baseDormitory 宿舍楼档案
     * @return 结果
     */
    @Override
    public int insertBaseDormitory(BaseDormitory baseDormitory)
    {
        return baseDormitoryMapper.insertBaseDormitory(baseDormitory);
    }

    /**
     * 修改宿舍楼档案
     * 
     * @param baseDormitory 宿舍楼档案
     * @return 结果
     */
    @Override
    public int updateBaseDormitory(BaseDormitory baseDormitory)
    {
        return baseDormitoryMapper.updateBaseDormitory(baseDormitory);
    }

    /**
     * 批量删除宿舍楼档案
     * 
     * @param ids 需要删除的宿舍楼档案ID
     * @return 结果
     */
    @Override
    public int deleteBaseDormitoryByIds(Long[] ids)
    {
        return baseDormitoryMapper.deleteBaseDormitoryByIds(ids);
    }

    /**
     * 删除宿舍楼档案信息
     * 
     * @param id 宿舍楼档案ID
     * @return 结果
     */
    @Override
    public int deleteBaseDormitoryById(Long id)
    {
        return baseDormitoryMapper.deleteBaseDormitoryById(id);
    }
}
