package com.ruoyi.hostel.controller;

import java.util.List;
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
import com.ruoyi.hostel.domain.BaseAccessControl;
import com.ruoyi.hostel.service.IBaseAccessControlService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 门禁设备Controller
 * 
 * @author ruoyi
 * @date 2021-05-28
 */
@RestController
@RequestMapping("/hostel/accessControl")
public class BaseAccessControlController extends BaseController
{
    @Autowired
    private IBaseAccessControlService baseAccessControlService;

    /**
     * 查询门禁设备列表
     */
    @PreAuthorize("@ss.hasPermi('hostel:accessControl:list')")
    @GetMapping("/list")
    public TableDataInfo list(BaseAccessControl baseAccessControl)
    {
        startPage();
        List<BaseAccessControl> list = baseAccessControlService.selectBaseAccessControlList(baseAccessControl);
        return getDataTable(list);
    }

    /**
     * 导出门禁设备列表
     */
    @PreAuthorize("@ss.hasPermi('hostel:accessControl:export')")
    @Log(title = "门禁设备", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(BaseAccessControl baseAccessControl)
    {
        List<BaseAccessControl> list = baseAccessControlService.selectBaseAccessControlList(baseAccessControl);
        ExcelUtil<BaseAccessControl> util = new ExcelUtil<BaseAccessControl>(BaseAccessControl.class);
        return util.exportExcel(list, "门禁设备数据");
    }

    /**
     * 获取门禁设备详细信息
     */
    @PreAuthorize("@ss.hasPermi('hostel:accessControl:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(baseAccessControlService.selectBaseAccessControlById(id));
    }

    /**
     * 新增门禁设备
     */
    @PreAuthorize("@ss.hasPermi('hostel:accessControl:add')")
    @Log(title = "门禁设备", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BaseAccessControl baseAccessControl)
    {
        return toAjax(baseAccessControlService.insertBaseAccessControl(baseAccessControl));
    }

    /**
     * 修改门禁设备
     */
    @PreAuthorize("@ss.hasPermi('hostel:accessControl:edit')")
    @Log(title = "门禁设备", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BaseAccessControl baseAccessControl)
    {
        return toAjax(baseAccessControlService.updateBaseAccessControl(baseAccessControl));
    }

    /**
     * 删除门禁设备
     */
    @PreAuthorize("@ss.hasPermi('hostel:accessControl:remove')")
    @Log(title = "门禁设备", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(baseAccessControlService.deleteBaseAccessControlByIds(ids));
    }
}
