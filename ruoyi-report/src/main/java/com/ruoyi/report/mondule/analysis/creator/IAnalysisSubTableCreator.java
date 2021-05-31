package com.ruoyi.report.mondule.analysis.creator;

import com.ruoyi.report.domain.ConfigShift;
import com.ruoyi.report.domain.ConfigSubTableCol;
import com.ruoyi.report.domain.ConfigSubTableRow;
import com.ruoyi.report.domain.dto.AnalysisSubTableData;
import com.ruoyi.report.mondule.analysis.strategy.IAnalysisStrategy;

import java.util.List;
import java.util.Map;

/**
 * @author wzh
 * @date 2021年05月12日 8:57
 */
public interface IAnalysisSubTableCreator {
    AnalysisSubTableData create(List<ConfigSubTableCol> configSubTableCols, List<ConfigSubTableRow> configSubTableRows, List<ConfigShift> configShifts, List<Map> dailyList, List<Map> totalList, IAnalysisStrategy strategy);

    String getName();
}
