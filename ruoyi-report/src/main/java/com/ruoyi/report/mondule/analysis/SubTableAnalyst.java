package com.ruoyi.report.mondule.analysis;

import com.ruoyi.report.domain.ConfigShift;
import com.ruoyi.report.domain.ConfigSubTable;
import com.ruoyi.report.domain.ConfigSubTableCol;
import com.ruoyi.report.domain.ConfigSubTableRow;
import com.ruoyi.report.domain.dto.AnalysisSubTableData;
import com.ruoyi.report.mondule.analysis.creator.*;
import com.ruoyi.report.mondule.analysis.strategy.*;
import com.ruoyi.report.mapper.ConfigSubTableMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @author wzh
 * @date 2021年05月12日 8:54
 */
@Component
public class SubTableAnalyst {
    @Autowired
    private ConfigSubTableMapper configSubTableMapper;

    @Autowired
    private StrategyManager strategyManager;

    @Autowired
    private CreatorManager creatorManager;

    public AnalysisSubTableData analysis(long id, List<ConfigSubTableCol> configSubTableCols, List<ConfigSubTableRow> configSubTableRows, List<ConfigShift> configShifts, List<Map> dailyList, List<Map> totalList) {
        ConfigSubTable configSubTable = configSubTableMapper.selectConfigSubTableById(id);
        String analysisStrategy = configSubTable.getAnalysisStrategy();
        String analysisCreator = configSubTable.getAnalysisCreator();

        IAnalysisStrategy strategy = strategyManager.getStrategy(analysisStrategy);
        IAnalysisSubTableCreator creator = creatorManager.getCreator(analysisCreator);

        if (creator != null) {
            return creator.create(configSubTableCols, configSubTableRows, configShifts, dailyList, totalList, strategy);
        } else {
            return createDefault(configSubTableCols, configSubTableRows, configShifts, dailyList, totalList, strategy);
        }
    }

    public AnalysisSubTableData createDefault(List<ConfigSubTableCol> configSubTableCols, List<ConfigSubTableRow> configSubTableRows, List<ConfigShift> configShifts, List<Map> dailyList, List<Map> totalList, IAnalysisStrategy strategy) {
        if (configShifts.isEmpty()) {
            if (!configSubTableCols.isEmpty() && !configSubTableRows.isEmpty()) {
                return new ColAndRowAnalysisCreator().create(configSubTableCols, configSubTableRows, configShifts, dailyList, totalList, strategy);
            } else if (!configSubTableCols.isEmpty()) {
                return new ColAnalysisCreator().create(configSubTableCols, configSubTableRows, configShifts, dailyList, totalList, strategy);
            }
        } else {
            if (!configSubTableCols.isEmpty() && !configSubTableRows.isEmpty()) {
                return new ColAndRowSumShiftCreator().create(configSubTableCols, configSubTableRows, configShifts, dailyList, totalList, strategy);
            } else if (!configSubTableCols.isEmpty()) {
                return new ColAndShiftAnalysisCreator().create(configSubTableCols, configSubTableRows, configShifts, dailyList, totalList, strategy);
            }
        }
        return null;
    }
}
