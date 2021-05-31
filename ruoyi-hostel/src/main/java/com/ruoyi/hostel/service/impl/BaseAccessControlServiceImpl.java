package com.ruoyi.hostel.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.hostel.mapper.BaseAccessControlMapper;
import com.ruoyi.hostel.domain.BaseAccessControl;
import com.ruoyi.hostel.service.IBaseAccessControlService;

/**
 * 门禁设备Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-05-28
 */
@Service
public class BaseAccessControlServiceImpl implements IBaseAccessControlService 
{
    @Autowired
    private BaseAccessControlMapper baseAccessControlMapper;

    /**
     * 查询门禁设备
     * 
     * @param id 门禁设备ID
     * @return 门禁设备
     */
    @Override
    public BaseAccessControl selectBaseAccessControlById(Long id)
    {
        return baseAccessControlMapper.selectBaseAccessControlById(id);
    }

    /**
     * 查询门禁设备列表
     * 
     * @param baseAccessControl 门禁设备
     * @return 门禁设备
     */
    @Override
    public List<BaseAccessControl> selectBaseAccessControlList(BaseAccessControl baseAccessControl)
    {
        return baseAccessControlMapper.selectBaseAccessControlList(baseAccessControl);
    }

    /**
     * 新增门禁设备
     * 
     * @param baseAccessControl 门禁设备
     * @return 结果
     */
    @Override
    public int insertBaseAccessControl(BaseAccessControl baseAccessControl)
    {
        return baseAccessControlMapper.insertBaseAccessControl(baseAccessControl);
    }

    /**
     * 修改门禁设备
     * 
     * @param baseAccessControl 门禁设备
     * @return 结果
     */
    @Override
    public int updateBaseAccessControl(BaseAccessControl baseAccessControl)
    {
        return baseAccessControlMapper.updateBaseAccessControl(baseAccessControl);
    }

    /**
     * 批量删除门禁设备
     * 
     * @param ids 需要删除的门禁设备ID
     * @return 结果
     */
    @Override
    public int deleteBaseAccessControlByIds(Long[] ids)
    {
        return baseAccessControlMapper.deleteBaseAccessControlByIds(ids);
    }

    /**
     * 删除门禁设备信息
     * 
     * @param id 门禁设备ID
     * @return 结果
     */
    @Override
    public int deleteBaseAccessControlById(Long id)
    {
        return baseAccessControlMapper.deleteBaseAccessControlById(id);
    }
}
