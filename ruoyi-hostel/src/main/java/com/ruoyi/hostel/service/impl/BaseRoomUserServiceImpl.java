package com.ruoyi.hostel.service.impl;

import java.util.List;

import com.ruoyi.hostel.domain.vo.SearchBaseRoomUserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.hostel.mapper.BaseRoomUserMapper;
import com.ruoyi.hostel.domain.BaseRoomUser;
import com.ruoyi.hostel.service.IBaseRoomUserService;

/**
 * 房间入住信息明细Service业务层处理
 *
 * @author ruoyi
 * @date 2021-05-29
 */
@Service
public class BaseRoomUserServiceImpl implements IBaseRoomUserService
{
    @Autowired
    private BaseRoomUserMapper baseRoomUserMapper;

    /**
     * 查询房间入住信息明细
     *
     * @param id 房间入住信息明细ID
     * @return 房间入住信息明细
     */
    @Override
    public BaseRoomUser selectBaseRoomUserById(Long id)
    {
        return baseRoomUserMapper.selectBaseRoomUserById(id);
    }

    /**
     * 查询房间入住信息明细列表
     *
     * @param baseRoomUser 房间入住信息明细
     * @return 房间入住信息明细
     */
    @Override
    public List<BaseRoomUser> selectBaseRoomUserList(BaseRoomUser baseRoomUser)
    {
        return baseRoomUserMapper.selectBaseRoomUserList(baseRoomUser);
    }


    /**
     * 根据房间id查询入住明细
     * @param roomId
     * @return
     */
    @Override
    public List<SearchBaseRoomUserVO> getRoomUserInfoPage(Long roomId) {
        return baseRoomUserMapper.getRoomUserInfoPage(roomId);
    }

    /**
     * 新增房间入住信息明细
     *
     * @param baseRoomUser 房间入住信息明细
     * @return 结果
     */
    @Override
    public int insertBaseRoomUser(BaseRoomUser baseRoomUser)
    {
        return baseRoomUserMapper.insertBaseRoomUser(baseRoomUser);
    }

    /**
     * 修改房间入住信息明细
     *
     * @param baseRoomUser 房间入住信息明细
     * @return 结果
     */
    @Override
    public int updateBaseRoomUser(BaseRoomUser baseRoomUser)
    {
        return baseRoomUserMapper.updateBaseRoomUser(baseRoomUser);
    }

    /**
     * 批量删除房间入住信息明细
     *
     * @param ids 需要删除的房间入住信息明细ID
     * @return 结果
     */
    @Override
    public int deleteBaseRoomUserByIds(Long[] ids)
    {
        return baseRoomUserMapper.deleteBaseRoomUserByIds(ids);
    }

    /**
     * 删除房间入住信息明细信息
     *
     * @param id 房间入住信息明细ID
     * @return 结果
     */
    @Override
    public int deleteBaseRoomUserById(Long id)
    {
        return baseRoomUserMapper.deleteBaseRoomUserById(id);
    }
}
