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
import com.ruoyi.report.domain.DataValue;
import com.ruoyi.report.service.IDataValueService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 具体数据Controller
 * 
 * @author wzh
 * @date 2021-05-03
 */
@RestController
@RequestMapping("/report/dvalue")
public class DataValueController extends BaseController
{
    @Autowired
    private IDataValueService dataValueService;

    /**
     * 查询具体数据列表
     */
    @PreAuthorize("@ss.hasPermi('report:dvalue:list')")
    @GetMapping("/list")
    public TableDataInfo list(DataValue dataValue)
    {
        startPage();
        List<DataValue> list = dataValueService.selectDataValueList(dataValue);
        return getDataTable(list);
    }

    /**
     * 导出具体数据列表
     */
    @PreAuthorize("@ss.hasPermi('report:dvalue:export')")
    @Log(title = "具体数据", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(DataValue dataValue)
    {
        List<DataValue> list = dataValueService.selectDataValueList(dataValue);
        ExcelUtil<DataValue> util = new ExcelUtil<DataValue>(DataValue.class);
        return util.exportExcel(list, "具体数据数据");
    }

    /**
     * 获取具体数据详细信息
     */
    @PreAuthorize("@ss.hasPermi('report:dvalue:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(dataValueService.selectDataValueById(id));
    }

    /**
     * 新增具体数据
     */
    @PreAuthorize("@ss.hasPermi('report:dvalue:add')")
    @Log(title = "具体数据", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody DataValue dataValue)
    {
        return toAjax(dataValueService.insertDataValue(dataValue));
    }

    /**
     * 修改具体数据
     */
    @PreAuthorize("@ss.hasPermi('report:dvalue:edit')")
    @Log(title = "具体数据", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody DataValue dataValue)
    {
        return toAjax(dataValueService.updateDataValue(dataValue));
    }

    /**
     * 删除具体数据
     */
    @PreAuthorize("@ss.hasPermi('report:dvalue:remove')")
    @Log(title = "具体数据", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(dataValueService.deleteDataValueByIds(ids));
    }
}
