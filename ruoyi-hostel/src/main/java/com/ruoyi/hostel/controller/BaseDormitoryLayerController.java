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
import com.ruoyi.hostel.domain.BaseDormitoryLayer;
import com.ruoyi.hostel.service.IBaseDormitoryLayerService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 宿舍楼层档案Controller
 * 
 * @author ruoyi
 * @date 2021-05-29
 */
@RestController
@RequestMapping("/hostel/layer")
public class BaseDormitoryLayerController extends BaseController
{
    @Autowired
    private IBaseDormitoryLayerService baseDormitoryLayerService;

    /**
     * 查询宿舍楼层档案列表
     */
    @PreAuthorize("@ss.hasPermi('hostel:layer:list')")
    @GetMapping("/list")
    public TableDataInfo list(BaseDormitoryLayer baseDormitoryLayer)
    {
        startPage();
        List<BaseDormitoryLayer> list = baseDormitoryLayerService.selectBaseDormitoryLayerList(baseDormitoryLayer);
        return getDataTable(list);
    }

    /**
     * 导出宿舍楼层档案列表
     */
    @PreAuthorize("@ss.hasPermi('hostel:layer:export')")
    @Log(title = "宿舍楼层档案", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(BaseDormitoryLayer baseDormitoryLayer)
    {
        List<BaseDormitoryLayer> list = baseDormitoryLayerService.selectBaseDormitoryLayerList(baseDormitoryLayer);
        ExcelUtil<BaseDormitoryLayer> util = new ExcelUtil<BaseDormitoryLayer>(BaseDormitoryLayer.class);
        return util.exportExcel(list, "宿舍楼层档案数据");
    }

    /**
     * 获取宿舍楼层档案详细信息
     */
    @PreAuthorize("@ss.hasPermi('hostel:layer:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(baseDormitoryLayerService.selectBaseDormitoryLayerById(id));
    }

    /**
     * 新增宿舍楼层档案
     */
    @PreAuthorize("@ss.hasPermi('hostel:layer:add')")
    @Log(title = "宿舍楼层档案", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BaseDormitoryLayer baseDormitoryLayer)
    {
        return toAjax(baseDormitoryLayerService.insertBaseDormitoryLayer(baseDormitoryLayer));
    }

    /**
     * 修改宿舍楼层档案
     */
    @PreAuthorize("@ss.hasPermi('hostel:layer:edit')")
    @Log(title = "宿舍楼层档案", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BaseDormitoryLayer baseDormitoryLayer)
    {
        return toAjax(baseDormitoryLayerService.updateBaseDormitoryLayer(baseDormitoryLayer));
    }

    /**
     * 删除宿舍楼层档案
     */
    @PreAuthorize("@ss.hasPermi('hostel:layer:remove')")
    @Log(title = "宿舍楼层档案", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(baseDormitoryLayerService.deleteBaseDormitoryLayerByIds(ids));
    }
}
