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
import com.ruoyi.report.domain.DataBase;
import com.ruoyi.report.service.IDataBaseService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 主基础数据信息
Controller
 * 
 * @author ruoyi
 * @date 2021-05-03
 */
@RestController
@RequestMapping("/report/base")
public class DataBaseController extends BaseController
{
    @Autowired
    private IDataBaseService dataBaseService;

    /**
     * 查询主基础数据信息
列表
     */
    @PreAuthorize("@ss.hasPermi('report:base:list')")
    @GetMapping("/list")
    public TableDataInfo list(DataBase dataBase)
    {
        startPage();
        List<DataBase> list = dataBaseService.selectDataBaseList(dataBase);
        return getDataTable(list);
    }

    /**
     * 导出主基础数据信息
列表
     */
    @PreAuthorize("@ss.hasPermi('report:base:export')")
    @Log(title = "主基础数据信息 ", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(DataBase dataBase)
    {
        List<DataBase> list = dataBaseService.selectDataBaseList(dataBase);
        ExcelUtil<DataBase> util = new ExcelUtil<DataBase>(DataBase.class);
        return util.exportExcel(list, "主基础数据信息 数据");
    }

    /**
     * 获取主基础数据信息
详细信息
     */
    @PreAuthorize("@ss.hasPermi('report:base:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(dataBaseService.selectDataBaseById(id));
    }

    /**
     * 新增主基础数据信息

     */
    @PreAuthorize("@ss.hasPermi('report:base:add')")
    @Log(title = "主基础数据信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody DataBase dataBase)
    {
        return toAjax(dataBaseService.insertDataBase(dataBase));
    }

    /**
     * 修改主基础数据信息

     */
    @PreAuthorize("@ss.hasPermi('report:base:edit')")
    @Log(title = "主基础数据信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody DataBase dataBase)
    {
        return toAjax(dataBaseService.updateDataBase(dataBase));
    }

    /**
     * 删除主基础数据信息

     */
    @PreAuthorize("@ss.hasPermi('report:base:remove')")
    @Log(title = "主基础数据信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(dataBaseService.deleteDataBaseByIds(ids));
    }
}
