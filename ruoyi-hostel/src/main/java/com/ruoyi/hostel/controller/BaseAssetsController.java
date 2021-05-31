package com.ruoyi.hostel.controller;

import java.util.List;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
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
import com.ruoyi.hostel.domain.BaseAssets;
import com.ruoyi.hostel.service.IBaseAssetsService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 资产档案Controller
 * 
 * @author ruoyi
 * @date 2021-05-28
 */
@Api(value = "资产管理控制器")
@RestController
@RequestMapping("/hostel/assets")
public class BaseAssetsController extends BaseController
{
    @Autowired
    private IBaseAssetsService baseAssetsService;

    /**
     * 查询资产档案列表
     */
    @ApiOperation("查询资产档案列表")
    @ApiImplicitParam(name = "baseAssets", value = "查询资产档案列表", dataType = "com.ruoyi.hostel.domain.BaseAssets")
    @PreAuthorize("@ss.hasPermi('hostel:assets:list')")
    @GetMapping("/list")
    public TableDataInfo list(BaseAssets baseAssets)
    {
        startPage();
        List<BaseAssets> list = baseAssetsService.selectBaseAssetsList(baseAssets);
        return getDataTable(list);
    }

    /**
     * 导出资产档案列表
     */
    @ApiOperation("导出资产档案列表")
    @ApiImplicitParam(name = "baseAssets", value = "导出资产档案列表", dataType = "BaseAssets")
    @PreAuthorize("@ss.hasPermi('hostel:assets:export')")
    @Log(title = "资产档案", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(BaseAssets baseAssets)
    {
        List<BaseAssets> list = baseAssetsService.selectBaseAssetsList(baseAssets);
        ExcelUtil<BaseAssets> util = new ExcelUtil<BaseAssets>(BaseAssets.class);
        return util.exportExcel(list, "资产档案数据");
    }

    /**
     * 获取资产档案详细信息
     */
    @ApiOperation("获取资产档案详细信息")
    @ApiImplicitParam(name = "id", value = "获取资产档案详细信息", dataType = "Long")
    @PreAuthorize("@ss.hasPermi('hostel:assets:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(baseAssetsService.selectBaseAssetsById(id));
    }

    /**
     * 新增资产档案
     */
    @ApiOperation("新增资产档案")
    @ApiImplicitParam(name = "baseAssets", value = "新增资产档案", dataType = "BaseAssets")
    @PreAuthorize("@ss.hasPermi('hostel:assets:add')")
    @Log(title = "资产档案", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BaseAssets baseAssets)
    {
        return toAjax(baseAssetsService.insertBaseAssets(baseAssets));
    }

    /**
     * 修改资产档案
     */
    @ApiOperation("修改资产档案")
    @ApiImplicitParam(name = "baseAssets", value = "修改资产档案", dataType = "BaseAssets")
    @PreAuthorize("@ss.hasPermi('hostel:assets:edit')")
    @Log(title = "资产档案", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BaseAssets baseAssets)
    {
        return toAjax(baseAssetsService.updateBaseAssets(baseAssets));
    }

    /**
     * 删除资产档案
     */
    @ApiOperation("删除资产档案")
    @ApiImplicitParam(name = "ids", value = "删除资产档案", dataType = "Long[]")
    @PreAuthorize("@ss.hasPermi('hostel:assets:remove')")
    @Log(title = "资产档案", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(baseAssetsService.deleteBaseAssetsByIds(ids));
    }
}
