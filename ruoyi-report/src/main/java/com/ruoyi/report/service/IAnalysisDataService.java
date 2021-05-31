package com.ruoyi.report.service;

import com.alibaba.fastjson.JSONObject;
import com.ruoyi.report.domain.dto.AnalysisSubTableData;
import com.ruoyi.report.domain.dto.DailyTableData;

/**
 * @author wzh
 * @date 2021年05月03日 11:38
 */
public interface IAnalysisDataService {

    AnalysisSubTableData getSubTableData(long mainTableId, long subTableId, String date);
}
