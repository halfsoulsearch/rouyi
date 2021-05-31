package com.ruoyi.hostel.mapper;

import java.util.List;
import com.ruoyi.hostel.domain.BaseAccessControl;

/**
 * 门禁设备Mapper接口
 * 
 * @author ruoyi
 * @date 2021-05-28
 */
public interface BaseAccessControlMapper 
{
    /**
     * 查询门禁设备
     * 
     * @param id 门禁设备ID
     * @return 门禁设备
     */
    public BaseAccessControl selectBaseAccessControlById(Long id);

    /**
     * 查询门禁设备列表
     * 
     * @param baseAccessControl 门禁设备
     * @return 门禁设备集合
     */
    public List<BaseAccessControl> selectBaseAccessControlList(BaseAccessControl baseAccessControl);

    /**
     * 新增门禁设备
     * 
     * @param baseAccessControl 门禁设备
     * @return 结果
     */
    public int insertBaseAccessControl(BaseAccessControl baseAccessControl);

    /**
     * 修改门禁设备
     * 
     * @param baseAccessControl 门禁设备
     * @return 结果
     */
    public int updateBaseAccessControl(BaseAccessControl baseAccessControl);

    /**
     * 删除门禁设备
     * 
     * @param id 门禁设备ID
     * @return 结果
     */
    public int deleteBaseAccessControlById(Long id);

    /**
     * 批量删除门禁设备
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteBaseAccessControlByIds(Long[] ids);
}
