package com.ruoyi.hostel.controller;

import java.util.List;

import com.ruoyi.hostel.domain.vo.SearchBaseRoomUserVO;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.hostel.domain.BaseRoomUser;
import com.ruoyi.hostel.service.IBaseRoomUserService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 房间入住信息明细Controller
 * 
 * @author ruoyi
 * @date 2021-05-29
 */
@RestController
@RequestMapping("/hostel/roomUser")
public class BaseRoomUserController extends BaseController
{
    @Autowired
    private IBaseRoomUserService baseRoomUserService;

    /**
     * 查询房间入住信息明细列表
     */
    @PreAuthorize("@ss.hasPermi('hostel:roomUser:list')")
    @GetMapping("/list")
    public TableDataInfo list(BaseRoomUser baseRoomUser)
    {
        startPage();
        List<BaseRoomUser> list = baseRoomUserService.selectBaseRoomUserList(baseRoomUser);
        return getDataTable(list);
    }


    /**
     * 查询房间入住信息明细列表
     */
//    @PreAuthorize("@ss.hasPermi('hostel:roomUser:list')")
    @PostMapping("/getRoomUserInfoPage")
    public TableDataInfo getRoomUserInfoPage(Long roomId)
    {
        startPage();
        List<SearchBaseRoomUserVO> list = baseRoomUserService.getRoomUserInfoPage(roomId);
        return getDataTable(list);
    }


    /**
     * 导出房间入住信息明细列表
     */
    @PreAuthorize("@ss.hasPermi('hostel:roomUser:export')")
    @Log(title = "房间入住信息明细", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(BaseRoomUser baseRoomUser)
    {
        List<BaseRoomUser> list = baseRoomUserService.selectBaseRoomUserList(baseRoomUser);
        ExcelUtil<BaseRoomUser> util = new ExcelUtil<BaseRoomUser>(BaseRoomUser.class);
        return util.exportExcel(list, "房间入住信息明细数据");
    }

    /**
     * 获取房间入住信息明细详细信息
     */
    @PreAuthorize("@ss.hasPermi('hostel:roomUser:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(baseRoomUserService.selectBaseRoomUserById(id));
    }

    /**
     * 新增房间入住信息明细
     */
    @PreAuthorize("@ss.hasPermi('hostel:roomUser:add')")
    @Log(title = "房间入住信息明细", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BaseRoomUser baseRoomUser)
    {
        return toAjax(baseRoomUserService.insertBaseRoomUser(baseRoomUser));
    }

    /**
     * 修改房间入住信息明细
     */
    @PreAuthorize("@ss.hasPermi('hostel:roomUser:edit')")
    @Log(title = "房间入住信息明细", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BaseRoomUser baseRoomUser)
    {
        return toAjax(baseRoomUserService.updateBaseRoomUser(baseRoomUser));
    }

    /**
     * 删除房间入住信息明细
     */
    @PreAuthorize("@ss.hasPermi('hostel:roomUser:remove')")
    @Log(title = "房间入住信息明细", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(baseRoomUserService.deleteBaseRoomUserByIds(ids));
    }
}
