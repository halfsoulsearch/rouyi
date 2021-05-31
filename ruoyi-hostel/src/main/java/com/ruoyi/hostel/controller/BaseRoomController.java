package com.ruoyi.hostel.controller;

import java.util.List;

import com.google.common.base.Throwables;
import com.ruoyi.common.exception.CustomException;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.hostel.domain.po.SaveBaseRoomPO;
import com.ruoyi.hostel.domain.po.SearchBaseRoomPO;
import com.ruoyi.hostel.domain.vo.SearchBaseRoomVO;
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
import com.ruoyi.hostel.domain.BaseRoom;
import com.ruoyi.hostel.service.IBaseRoomService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 房间档案Controller
 *
 * @author ruoyi
 * @date 2021-05-28
 */
@RestController
@RequestMapping("/hostel/room")
public class BaseRoomController extends BaseController {
    @Autowired
    private IBaseRoomService baseRoomService;

    /**
     * 查询房间档案列表
     */
    @PreAuthorize("@ss.hasPermi('hostel:room:list')")
    @PostMapping("/searchBaseRoom")
    public TableDataInfo searchBaseRoom(@RequestBody SearchBaseRoomPO request) {
        startPage();
        List<SearchBaseRoomVO> list = baseRoomService.selectBaseRoomList(request);
        return getDataTable(list);
    }

    /**
     * 导出房间档案列表
     */
    @PreAuthorize("@ss.hasPermi('hostel:room:export')")
    @Log(title = "房间档案", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(@RequestBody SearchBaseRoomPO request) {
        List<SearchBaseRoomVO> list = baseRoomService.selectBaseRoomList(request);
        ExcelUtil<SearchBaseRoomVO> util = new ExcelUtil<>(SearchBaseRoomVO.class);
        return util.exportExcel(list, "房间档案数据");
    }

    /**
     * 获取房间档案详细信息
     */
    @PreAuthorize("@ss.hasPermi('hostel:room:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(baseRoomService.selectBaseRoomById(id));
    }

    /**
     * 新增房间档案
     */
    @PreAuthorize("@ss.hasPermi('hostel:room:add')")
    @Log(title = "房间档案", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BaseRoom baseRoom) {
        return toAjax(baseRoomService.insertBaseRoom(baseRoom));
    }


    /**
     * 新增房间档案
     */
//    @PreAuthorize("@ss.hasPermi('hostel:room:add')")
    @Log(title = "房间档案", businessType = BusinessType.INSERT)
    @PostMapping("/saveRoom")
    public AjaxResult saveRoom(@RequestBody SaveBaseRoomPO request) {
        try {
            if (StringUtils.isEmpty(request.getDormitoryNumber())){
                throw new CustomException("所属楼号不能为空！");
            }
            if (StringUtils.isEmpty(request.getLayerNumber())){
                throw new CustomException("所属层号不能为空！");
            }

            return toAjax(baseRoomService.saveRoom(request));
        }catch (CustomException e) {
            return error(e.getMessage());
        } catch (Exception e) {
            logger.error("新增房间档案失败！原因{}", Throwables.getStackTraceAsString(e));
            return error("新增房间档案失败");
        }


    }


    /**
     * 修改房间档案
     */
    @PreAuthorize("@ss.hasPermi('hostel:room:edit')")
    @Log(title = "房间档案", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BaseRoom baseRoom) {
        return toAjax(baseRoomService.updateBaseRoom(baseRoom));
    }

    /**
     * 删除房间档案
     */
    @PreAuthorize("@ss.hasPermi('hostel:room:remove')")
    @Log(title = "房间档案", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(baseRoomService.deleteBaseRoomByIds(ids));
    }
}
