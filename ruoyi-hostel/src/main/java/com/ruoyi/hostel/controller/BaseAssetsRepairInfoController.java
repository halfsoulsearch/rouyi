package com.ruoyi.hostel.controller;

import java.util.List;

import com.ruoyi.hostel.domain.vo.SearchBaseAssetsRepairInfoVO;
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
import com.ruoyi.hostel.domain.BaseAssetsRepairInfo;
import com.ruoyi.hostel.service.IBaseAssetsRepairInfoService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 资产维修记录Controller
 * 
 * @author ruoyi
 * @date 2021-05-29
 */
@RestController
@RequestMapping("/hostel/info")
public class BaseAssetsRepairInfoController extends BaseController
{
    @Autowired
    private IBaseAssetsRepairInfoService baseAssetsRepairInfoService;

    /**
     * 查询资产维修记录列表
     */
//    @PreAuthorize("@ss.hasPermi('hostel:info:list')")
    @GetMapping("/list")
    public TableDataInfo list(BaseAssetsRepairInfo baseAssetsRepairInfo)
    {
        startPage();
        List<BaseAssetsRepairInfo> list = baseAssetsRepairInfoService.selectBaseAssetsRepairInfoList(baseAssetsRepairInfo);
        return getDataTable(list);
    }


    /**
     *
     * @param assetsId
     * @return
     */
    @PostMapping("/getRepairInfoPage")
    public TableDataInfo getRepairInfoPage(Long assetsId) {
        startPage();
        List<SearchBaseAssetsRepairInfoVO> list = baseAssetsRepairInfoService.getRepairInfoPage(assetsId);
        return getDataTable(list);
    }

    /**
     * 导出资产维修记录列表
     */
//    @PreAuthorize("@ss.hasPermi('hostel:info:export')")
    @Log(title = "资产维修记录", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(BaseAssetsRepairInfo baseAssetsRepairInfo)
    {
        List<BaseAssetsRepairInfo> list = baseAssetsRepairInfoService.selectBaseAssetsRepairInfoList(baseAssetsRepairInfo);
        ExcelUtil<BaseAssetsRepairInfo> util = new ExcelUtil<BaseAssetsRepairInfo>(BaseAssetsRepairInfo.class);
        return util.exportExcel(list, "资产维修记录数据");
    }

    /**
     * 获取资产维修记录详细信息
     */
//    @PreAuthorize("@ss.hasPermi('hostel:info:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(baseAssetsRepairInfoService.selectBaseAssetsRepairInfoById(id));
    }

    /**
     * 新增资产维修记录
     */
//    @PreAuthorize("@ss.hasPermi('hostel:info:add')")
    @Log(title = "资产维修记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BaseAssetsRepairInfo baseAssetsRepairInfo)
    {
        return toAjax(baseAssetsRepairInfoService.insertBaseAssetsRepairInfo(baseAssetsRepairInfo));
    }

    /**
     * 修改资产维修记录
     */
//    @PreAuthorize("@ss.hasPermi('hostel:info:edit')")
    @Log(title = "资产维修记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BaseAssetsRepairInfo baseAssetsRepairInfo)
    {
        return toAjax(baseAssetsRepairInfoService.updateBaseAssetsRepairInfo(baseAssetsRepairInfo));
    }

    /**
     * 删除资产维修记录
     */
//    @PreAuthorize("@ss.hasPermi('hostel:info:remove')")
    @Log(title = "资产维修记录", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(baseAssetsRepairInfoService.deleteBaseAssetsRepairInfoByIds(ids));
    }
}
