package com.ruoyi.report.service;


import com.ruoyi.report.domain.vo.DayReport;

import java.util.List;
import java.util.Map;

public interface IDayReportService {

    /**
     * 查询报表列表
     *
     * @param dayReport 日报表
     * @return 日报表集合
     */
    public List<DayReport> selectDayReportList(DayReport dayReport);

    /**
     * 每个班的当日数据
     *
     * @param params
     *
     * main_table_id 主表ID
     * sub_table_id 字表ID
     * date 日期
     *
     * @return
     */
    public List<Map> ballDayReportAnalyse(Map params);

    /**
     * 查询每个班次当月度累计数
     *
     * @param params
     *
     * main_table_id 主表ID
     * sub_table_id 字表ID
     * date 日期
     *
     * @return
     */
    public List<Map> ballDayReportAnalyseTotal(Map params);
}
