package com.yimi.product.enums;

public enum ExceptionEnum {
    UNKNOW_ERROR(-1,"未知错误"),
    USER_IS_EXIT(-101,"用户已存在"),
    AccountIsLocked(1,"账户已被锁定,请60秒以后重试"),
    UnauthorizedException(2,"无访问权限");

    private Integer code;

    private String msg;

    ExceptionEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
