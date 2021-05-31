package com.ruoyi.report.mondule.analysis.strategy;

import com.ruoyi.common.utils.StringUtils;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author wzh
 * @date 2021年05月12日 10:35
 */
@Component
public class StrategyManager {
    public Map<String, IAnalysisStrategy> strategyMap;

    @PostConstruct
    public void registerStrategy() {
        List<IAnalysisStrategy> strategyList = new ArrayList<>();
        strategyList.add(new DefaultAnalysisStrategy());
        strategyList.add(new TotalAnalysisStrategy());
        strategyList.add(new CostAnalysisStrategy());
        strategyList.add(new LinePTAnalysisStrategy());


        strategyMap = strategyList.stream().collect(Collectors.toMap(IAnalysisStrategy::getName, strategy -> strategy));
    }

    public IAnalysisStrategy getStrategy(String strategy) {
        if (strategyMap.containsKey(strategy)) {
            return strategyMap.get(strategy);
        }
        return new DefaultAnalysisStrategy();
    }
}
