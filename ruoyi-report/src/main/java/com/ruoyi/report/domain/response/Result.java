package com.ruoyi.report.domain.response;

import lombok.Data;

/**
 +-------------------------------------------------------
 | 描述：接口返回类
 +--------------------------------------------------------
 | 作者：刘利涛
 +--------------------------------------------------------
 | 版权：Copyright (c) 2021 晋钢集团 All rights reserved.
 +--------------------------------------------------------
 | 日期：2021年4月9日14:16:27
 +--------------------------------------------------------
 **/

@Data
public class Result<T>{

    /**
     * 错 误 状 态
     */

    private int code;

    /**
     * 错 误 消 息
     */

    private String msg;

    /**
     * 返 回 数 据
     */
    private T data;



}
