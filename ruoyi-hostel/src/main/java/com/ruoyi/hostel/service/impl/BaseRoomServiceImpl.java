package com.ruoyi.hostel.service.impl;

import com.ruoyi.common.core.domain.model.LoginUser;
import com.ruoyi.common.exception.CustomException;
import com.ruoyi.common.utils.ServletUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.hostel.domain.BaseRoom;
import com.ruoyi.hostel.domain.po.SaveBaseRoomPO;
import com.ruoyi.hostel.domain.po.SearchBaseRoomPO;
import com.ruoyi.hostel.domain.vo.SearchBaseRoomVO;
import com.ruoyi.hostel.mapper.BaseRoomMapper;
import com.ruoyi.hostel.service.IBaseRoomService;
import org.springframework.beans.factory.annotation.Autowired;

import com.ruoyi.framework.web.service.*;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * 房间档案Service业务层处理
 *
 * @author ruoyi
 * @date 2021-05-28
 */
@Service
public class BaseRoomServiceImpl implements IBaseRoomService {
    @Autowired
    private BaseRoomMapper baseRoomMapper;

    @Autowired
    private TokenService tokenService;

    /**
     * 查询房间档案
     *
     * @param id 房间档案ID
     * @return 房间档案
     */
    @Override
    public BaseRoom selectBaseRoomById(Long id) {
        return baseRoomMapper.selectBaseRoomById(id);
    }

    /**
     * 查询房间档案列表
     *
     * @return 房间档案
     */
    @Override
    public List<SearchBaseRoomVO> selectBaseRoomList(SearchBaseRoomPO request) {
        return baseRoomMapper.selectBaseRoomList(request);
    }

    /**
     * 新增房间档案
     *
     * @param baseRoom 房间档案
     * @return 结果
     */
    @Override
    public int insertBaseRoom(BaseRoom baseRoom) {
        return baseRoomMapper.insertBaseRoom(baseRoom);
    }


    /**
     * 房间新增
     *
     * @param request
     * @return
     */
    @Override
    public int saveRoom(SaveBaseRoomPO request) {
        BaseRoom from = new BaseRoom();
        from.setDormitoryId(request.getDormitoryId());
        from.setLayerId(request.getLayerId());
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(request.getDormitoryNumber()).append(request.getLayerNumber()).append(request.getRoomNumber());
        from.setRoomCode(stringBuffer.toString());
        from.setRoomNumber(request.getRoomNumber());
        from.setElectricCode(request.getElectricCode());
        from.setElectricPlace(request.getElectricPlace());
        from.setRoomRank(request.getRoomRank());
        from.setRoomState(request.getRoomState());
        from.setRoomStandard(request.getRoomStandard());
        from.setRoomType(request.getRoomType());
        from.setWaterCode(request.getWaterCode());
        from.setWaterPlace(request.getWaterPlace());
        LoginUser loginUser = tokenService.getLoginUser(ServletUtils.getRequest());
        if (StringUtils.isNull(loginUser)) {
            throw new CustomException("未找到当前登录用户！");
        }
        from.setCreateCode(loginUser.getUser().getUserName());
        from.setCreateName(loginUser.getUser().getNickName());
        from.setIsDeleted(0L);

        return baseRoomMapper.insertBaseRoom(from);

    }

    /**
     * 修改房间档案
     *
     * @param baseRoom 房间档案
     * @return 结果
     */
    @Override
    public int updateBaseRoom(BaseRoom baseRoom) {
        return baseRoomMapper.updateBaseRoom(baseRoom);
    }

    /**
     * 批量删除房间档案
     *
     * @param ids 需要删除的房间档案ID
     * @return 结果
     */
    @Override
    public int deleteBaseRoomByIds(Long[] ids) {
        return baseRoomMapper.deleteBaseRoomByIds(ids);
    }

    /**
     * 删除房间档案信息
     *
     * @param id 房间档案ID
     * @return 结果
     */
    @Override
    public int deleteBaseRoomById(Long id) {
        return baseRoomMapper.deleteBaseRoomById(id);
    }
}
