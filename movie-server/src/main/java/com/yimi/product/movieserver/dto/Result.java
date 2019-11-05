package com.yimi.product.movieserver.dto;

/**
 * @Author 黄昌焕
 * @Date 2018-09-07  12:58
 */
public class Result {
    private String code="000";
    private String mesg="处理成功";

    public void setCode(String code) {
        this.code = code;
    }

    public void setMesg(String mesg) {
        this.mesg = mesg;
    }

    public String getCode() {
        return code;
    }

    public String getMesg() {
        return mesg;
    }
}
