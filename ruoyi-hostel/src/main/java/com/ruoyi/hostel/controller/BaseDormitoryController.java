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
import com.ruoyi.hostel.domain.BaseDormitory;
import com.ruoyi.hostel.service.IBaseDormitoryService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 宿舍楼档案Controller
 * 
 * @author lfx
 * @date 2021-05-28
 */
@RestController
@RequestMapping("/hostel/dormitory")
public class BaseDormitoryController extends BaseController
{
    @Autowired
    private IBaseDormitoryService baseDormitoryService;

    /**
     * 查询宿舍楼档案列表
     */
    @PreAuthorize("@ss.hasPermi('hostel:dormitory:list')")
    @GetMapping("/list")
    public TableDataInfo list(BaseDormitory baseDormitory)
    {
        startPage();
        List<BaseDormitory> list = baseDormitoryService.selectBaseDormitoryList(baseDormitory);
        return getDataTable(list);
    }

    /**
     * 导出宿舍楼档案列表
     */
    @PreAuthorize("@ss.hasPermi('hostel:dormitory:export')")
    @Log(title = "宿舍楼档案", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(BaseDormitory baseDormitory)
    {
        List<BaseDormitory> list = baseDormitoryService.selectBaseDormitoryList(baseDormitory);
        ExcelUtil<BaseDormitory> util = new ExcelUtil<BaseDormitory>(BaseDormitory.class);
        return util.exportExcel(list, "宿舍楼档案数据");
    }

    /**
     * 获取宿舍楼档案详细信息
     */
    @PreAuthorize("@ss.hasPermi('hostel:dormitory:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(baseDormitoryService.selectBaseDormitoryById(id));
    }

    /**
     * 新增宿舍楼档案
     */
    @PreAuthorize("@ss.hasPermi('hostel:dormitory:add')")
    @Log(title = "宿舍楼档案", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BaseDormitory baseDormitory)
    {
        return toAjax(baseDormitoryService.insertBaseDormitory(baseDormitory));
    }

    /**
     * 修改宿舍楼档案
     */
    @PreAuthorize("@ss.hasPermi('hostel:dormitory:edit')")
    @Log(title = "宿舍楼档案", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BaseDormitory baseDormitory)
    {
        return toAjax(baseDormitoryService.updateBaseDormitory(baseDormitory));
    }

    /**
     * 删除宿舍楼档案
     */
    @PreAuthorize("@ss.hasPermi('hostel:dormitory:remove')")
    @Log(title = "宿舍楼档案", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(baseDormitoryService.deleteBaseDormitoryByIds(ids));
    }
}
