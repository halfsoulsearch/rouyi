package com.ruoyi.report.service;

import com.alibaba.fastjson.JSONObject;
import com.ruoyi.report.domain.dto.DailyTableData;

import java.util.Date;

/**
 * @author wzh
 * @date 2021年05月03日 11:38
 */
public interface IAssembleDataService {
    DailyTableData preCreateTable(long mainTableId, String dateStr, long shiftId, long userId);

    void createOrUpdateTable(JSONObject data);

    DailyTableData getTableData(long baseTableId, long shiftId);

    void deleteTable(long mainTableId);
}
