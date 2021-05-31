package com.ruoyi.report.domain.response;

import lombok.Getter;

/**
 +-------------------------------------------------------
 | 描述：接口状态返回码
 +--------------------------------------------------------
 | 作者：刘利涛
 +--------------------------------------------------------
 | 版权：Copyright (c) 2021 晋钢集团 All rights reserved.
 +--------------------------------------------------------
 | 日期：2021年4月9日14:16:27
 +--------------------------------------------------------
 **/
public enum ResultCode {

    /**
     * 成功
     */
    SUCCESS(200,"操作成功"),
    /**
     * 失败
     */
    FAILURE(500,"操作失败");

    /**
     * 状 态 码
     * */
    @Getter
    private int code;

    /**
     * 携 带 消 息
     * */
    @Getter
    private String message;

    /**
     * 构 造 方 法
     * */
    ResultCode(int code, String message) {

        this.code = code;

        this.message = message;
    }

}
