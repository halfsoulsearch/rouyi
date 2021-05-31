package com.ruoyi.hostel.service;

import java.util.List;
import com.ruoyi.hostel.domain.BaseRoomUser;
import com.ruoyi.hostel.domain.vo.SearchBaseRoomUserVO;

/**
 * 房间入住信息明细Service接口
 *
 * @author ruoyi
 * @date 2021-05-29
 */
public interface IBaseRoomUserService
{
    /**
     * 查询房间入住信息明细
     *
     * @param id 房间入住信息明细ID
     * @return 房间入住信息明细
     */
    public BaseRoomUser selectBaseRoomUserById(Long id);

    /**
     * 查询房间入住信息明细列表
     *
     * @param baseRoomUser 房间入住信息明细
     * @return 房间入住信息明细集合
     */
    public List<BaseRoomUser> selectBaseRoomUserList(BaseRoomUser baseRoomUser);


    /**
     * 根据房间id查询入住明细
     * @param roomId
     * @return
     */
    List<SearchBaseRoomUserVO> getRoomUserInfoPage(Long roomId);







    /**
     * 新增房间入住信息明细
     *
     * @param baseRoomUser 房间入住信息明细
     * @return 结果
     */
    public int insertBaseRoomUser(BaseRoomUser baseRoomUser);

    /**
     * 修改房间入住信息明细
     *
     * @param baseRoomUser 房间入住信息明细
     * @return 结果
     */
    public int updateBaseRoomUser(BaseRoomUser baseRoomUser);

    /**
     * 批量删除房间入住信息明细
     *
     * @param ids 需要删除的房间入住信息明细ID
     * @return 结果
     */
    public int deleteBaseRoomUserByIds(Long[] ids);

    /**
     * 删除房间入住信息明细信息
     *
     * @param id 房间入住信息明细ID
     * @return 结果
     */
    public int deleteBaseRoomUserById(Long id);
}
