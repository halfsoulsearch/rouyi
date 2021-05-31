package com.ruoyi.report.service.impl;


import com.ruoyi.RuoYiApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {RuoYiApplication.class})
public class ConfigShiftServiceImplTest {

    @Resource
    ConfigShiftServiceImpl configShiftService;
    @Resource
    AssembleDataServiceImpl assembleDataService;

    @Test
    public void selectConfigShiftById() {
        System.out.println("assembleDataService = " + assembleDataService);
    }

    @Test
    public void selectConfigShiftList() {
        System.out.println(configShiftService);
    }
}