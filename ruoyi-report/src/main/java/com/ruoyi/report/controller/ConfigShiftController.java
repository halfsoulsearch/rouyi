package com.ruoyi.report.controller;

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
import com.ruoyi.report.domain.ConfigShift;
import com.ruoyi.report.service.IConfigShiftService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 班次Controller
 * 
 * @author wzy
 * @date 2021-05-02
 */
@RestController
@RequestMapping("/report/shift")
public class ConfigShiftController extends BaseController
{
    @Autowired
    private IConfigShiftService configShiftService;

    /**
     * 查询班次列表
     */
    @PreAuthorize("@ss.hasPermi('report:shift:list')")
    @GetMapping("/list")
    public TableDataInfo list(ConfigShift configShift)
    {
        startPage();
        List<ConfigShift> list = configShiftService.selectConfigShiftList(configShift);
        return getDataTable(list);
    }

    /**
     * 导出班次列表
     */
    @PreAuthorize("@ss.hasPermi('report:shift:export')")
    @Log(title = "班次", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(ConfigShift configShift)
    {
        List<ConfigShift> list = configShiftService.selectConfigShiftList(configShift);
        ExcelUtil<ConfigShift> util = new ExcelUtil<ConfigShift>(ConfigShift.class);
        return util.exportExcel(list, "班次数据");
    }

    /**
     * 获取班次详细信息
     */
    @PreAuthorize("@ss.hasPermi('report:shift:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(configShiftService.selectConfigShiftById(id));
    }

    /**
     * 新增班次
     */
    @PreAuthorize("@ss.hasPermi('report:shift:add')")
    @Log(title = "班次", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ConfigShift configShift)
    {
        return toAjax(configShiftService.insertConfigShift(configShift));
    }

    /**
     * 修改班次
     */
    @PreAuthorize("@ss.hasPermi('report:shift:edit')")
    @Log(title = "班次", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ConfigShift configShift)
    {
        return toAjax(configShiftService.updateConfigShift(configShift));
    }

    /**
     * 删除班次
     */
    @PreAuthorize("@ss.hasPermi('report:shift:remove')")
    @Log(title = "班次", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(configShiftService.deleteConfigShiftByIds(ids));
    }
}
