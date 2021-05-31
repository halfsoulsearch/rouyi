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
import com.ruoyi.report.domain.ConfigMainTable;
import com.ruoyi.report.service.IConfigMainTableService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 主的配置Controller
 * 
 * @author wzy
 * @date 2021-05-02
 */
@RestController
@RequestMapping("/report/mtable")
public class ConfigMainTableController extends BaseController
{
    @Autowired
    private IConfigMainTableService configMainTableService;

    /**
     * 查询主的配置列表
     */
    @PreAuthorize("@ss.hasPermi('report:mtable:list')")
    @GetMapping("/list")
    public TableDataInfo list(ConfigMainTable configMainTable)
    {
        startPage();
        List<ConfigMainTable> list = configMainTableService.selectConfigMainTableList(configMainTable);
        return getDataTable(list);
    }

    /**
     * 导出主的配置列表
     */
    @PreAuthorize("@ss.hasPermi('report:mtable:export')")
    @Log(title = "主的配置", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(ConfigMainTable configMainTable)
    {
        List<ConfigMainTable> list = configMainTableService.selectConfigMainTableList(configMainTable);
        ExcelUtil<ConfigMainTable> util = new ExcelUtil<ConfigMainTable>(ConfigMainTable.class);
        return util.exportExcel(list, "主的配置数据");
    }

    /**
     * 获取主的配置详细信息
     */
    @PreAuthorize("@ss.hasPermi('report:mtable:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(configMainTableService.selectConfigMainTableById(id));
    }

    /**
     * 新增主的配置
     */
    @PreAuthorize("@ss.hasPermi('report:mtable:add')")
    @Log(title = "主的配置", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ConfigMainTable configMainTable)
    {
        return toAjax(configMainTableService.insertConfigMainTable(configMainTable));
    }

    /**
     * 修改主的配置
     */
    @PreAuthorize("@ss.hasPermi('report:mtable:edit')")
    @Log(title = "主的配置", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ConfigMainTable configMainTable)
    {
        return toAjax(configMainTableService.updateConfigMainTable(configMainTable));
    }

    /**
     * 删除主的配置
     */
    @PreAuthorize("@ss.hasPermi('report:mtable:remove')")
    @Log(title = "主的配置", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(configMainTableService.deleteConfigMainTableByIds(ids));
    }
}
