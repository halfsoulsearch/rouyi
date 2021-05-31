//package com.ruoyi.hostel.controller;
//
//import com.ruoyi.common.annotation.Log;
//import com.ruoyi.common.core.controller.BaseController;
//import com.ruoyi.common.core.domain.AjaxResult;
//import com.ruoyi.common.core.page.TableDataInfo;
//import com.ruoyi.common.enums.BusinessType;
//import com.ruoyi.common.utils.poi.ExcelUtil;
//import com.ruoyi.hostel.domain.BaseRoomAssets;
//import com.ruoyi.hostel.service.IBaseRoomAssetsService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
///**
// * 房间资产关系Controller
// *
// * @author ruoyi
// * @date 2021-05-29
// */
//@RestController
//@RequestMapping("/hostel/assets")
//public class BaseRoomAssetsController extends BaseController
//{
//    @Autowired
//    private IBaseRoomAssetsService baseRoomAssetsService;
//
//    /**
//     * 查询房间资产关系列表
//     */
//    @PreAuthorize("@ss.hasPermi('hostel:assets:list')")
//    @GetMapping("/list")
//    public TableDataInfo list(BaseRoomAssets baseRoomAssets)
//    {
//        startPage();
//        List<BaseRoomAssets> list = baseRoomAssetsService.selectBaseRoomAssetsList(baseRoomAssets);
//        return getDataTable(list);
//    }
//
//    /**
//     * 导出房间资产关系列表
//     */
//    @PreAuthorize("@ss.hasPermi('hostel:assets:export')")
//    @Log(title = "房间资产关系", businessType = BusinessType.EXPORT)
//    @GetMapping("/export")
//    public AjaxResult export(BaseRoomAssets baseRoomAssets)
//    {
//        List<BaseRoomAssets> list = baseRoomAssetsService.selectBaseRoomAssetsList(baseRoomAssets);
//        ExcelUtil<BaseRoomAssets> util = new ExcelUtil<BaseRoomAssets>(BaseRoomAssets.class);
//        return util.exportExcel(list, "房间资产关系数据");
//    }
//
//    /**
//     * 获取房间资产关系详细信息
//     */
//    @PreAuthorize("@ss.hasPermi('hostel:assets:query')")
//    @GetMapping(value = "/{id}")
//    public AjaxResult getInfo(@PathVariable("id") Long id)
//    {
//        return AjaxResult.success(baseRoomAssetsService.selectBaseRoomAssetsById(id));
//    }
//
//    /**
//     * 新增房间资产关系
//     */
//    @PreAuthorize("@ss.hasPermi('hostel:assets:add')")
//    @Log(title = "房间资产关系", businessType = BusinessType.INSERT)
//    @PostMapping("/add")
//    public AjaxResult add(@RequestBody BaseRoomAssets baseRoomAssets)
//    {
//        return toAjax(baseRoomAssetsService.insertBaseRoomAssets(baseRoomAssets));
//    }
//
//    /**
//     * 修改房间资产关系
//     */
//    @PreAuthorize("@ss.hasPermi('hostel:assets:edit')")
//    @Log(title = "房间资产关系", businessType = BusinessType.UPDATE)
//    @PutMapping
//    public AjaxResult edit(@RequestBody BaseRoomAssets baseRoomAssets)
//    {
//        return toAjax(baseRoomAssetsService.updateBaseRoomAssets(baseRoomAssets));
//    }
//
//    /**
//     * 删除房间资产关系
//     */
//    @PreAuthorize("@ss.hasPermi('hostel:assets:remove')")
//    @Log(title = "房间资产关系", businessType = BusinessType.DELETE)
//	@DeleteMapping("/remove/{ids}")
//    public AjaxResult remove(@PathVariable Long[] ids)
//    {
//        return toAjax(baseRoomAssetsService.deleteBaseRoomAssetsByIds(ids));
//    }
//}
