package com.ruoyi.report.mondule.analysis.creator;

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
public class CreatorManager {
    public Map<String, IAnalysisSubTableCreator> creatorMap;

    @PostConstruct
    public void registerCreator() {
        List<IAnalysisSubTableCreator> creatorList = new ArrayList<>();
        creatorList.add(new BurnBaseAnalysisSubTableCreator());
        creatorList.add(new RecordAnalysisCreator());
        creatorList.add(new CostAnalysisCreator());
        creatorList.add(new ColSumShiftAnalysisCreator());
        creatorMap = creatorList.stream().collect(Collectors.toMap(IAnalysisSubTableCreator::getName, creator -> creator));
    }

    public IAnalysisSubTableCreator getCreator(String creator) {
        if (creatorMap.containsKey(creator)) {
            return creatorMap.get(creator);
        }
        return null;
    }
}
