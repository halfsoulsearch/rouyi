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
import com.ruoyi.hostel.domain.BaseTypeGroup;
import com.ruoyi.hostel.service.IBaseTypeGroupService;
import com.ruoyi.common.utils.poi.ExcelUtil;

/**
 * 类型组Controller
 * 
 * @author ruoyi
 * @date 2021-05-29
 */
@RestController
@RequestMapping("/hostel/group")
public class BaseTypeGroupController extends BaseController
{
    @Autowired
    private IBaseTypeGroupService baseTypeGroupService;

    /**
     * 查询类型组列表
     */
    @PreAuthorize("@ss.hasPermi('hostel:group:list')")
    @GetMapping("/list")
    public AjaxResult list(BaseTypeGroup baseTypeGroup)
    {
        List<BaseTypeGroup> list = baseTypeGroupService.selectBaseTypeGroupList(baseTypeGroup);
        return AjaxResult.success(list);
    }

    /**
     * 导出类型组列表
     */
    @PreAuthorize("@ss.hasPermi('hostel:group:export')")
    @Log(title = "类型组", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(BaseTypeGroup baseTypeGroup)
    {
        List<BaseTypeGroup> list = baseTypeGroupService.selectBaseTypeGroupList(baseTypeGroup);
        ExcelUtil<BaseTypeGroup> util = new ExcelUtil<BaseTypeGroup>(BaseTypeGroup.class);
        return util.exportExcel(list, "类型组数据");
    }

    /**
     * 获取类型组详细信息
     */
    @PreAuthorize("@ss.hasPermi('hostel:group:query')")
    @GetMapping(value = "/{baseTypeId}")
    public AjaxResult getInfo(@PathVariable("baseTypeId") Long baseTypeId)
    {
        return AjaxResult.success(baseTypeGroupService.selectBaseTypeGroupById(baseTypeId));
    }

    /**
     * 新增类型组
     */
    @PreAuthorize("@ss.hasPermi('hostel:group:add')")
    @Log(title = "类型组", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BaseTypeGroup baseTypeGroup)
    {
        return toAjax(baseTypeGroupService.insertBaseTypeGroup(baseTypeGroup));
    }

    /**
     * 修改类型组
     */
    @PreAuthorize("@ss.hasPermi('hostel:group:edit')")
    @Log(title = "类型组", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BaseTypeGroup baseTypeGroup)
    {
        return toAjax(baseTypeGroupService.updateBaseTypeGroup(baseTypeGroup));
    }

    /**
     * 删除类型组
     */
    @PreAuthorize("@ss.hasPermi('hostel:group:remove')")
    @Log(title = "类型组", businessType = BusinessType.DELETE)
	@DeleteMapping("/{baseTypeIds}")
    public AjaxResult remove(@PathVariable Long[] baseTypeIds)
    {
        return toAjax(baseTypeGroupService.deleteBaseTypeGroupByIds(baseTypeIds));
    }
}
