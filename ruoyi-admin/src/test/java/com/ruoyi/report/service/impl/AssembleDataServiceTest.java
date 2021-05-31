package com.ruoyi.report.service.impl;

import com.ruoyi.RuoYiApplication;
import com.ruoyi.report.domain.DataValue;
import com.ruoyi.report.domain.dto.*;
import org.junit.Test;
import org.junit.jupiter.api.Disabled;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author wzh
 * @date 2021年05月03日 16:58
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {RuoYiApplication.class})
@Disabled
public class AssembleDataServiceTest {

    @Autowired
    public AnalysisDataServiceImpl analysisDataService;

    @Test
    public void test() {
        System.out.println(analysisDataService.getSubTableData(3, 13, "2021-05-11"));
        System.out.println(new AnalysisSubTableConverter(analysisDataService.getSubTableData(3, 13, "2021-05-11")));

    }
}
