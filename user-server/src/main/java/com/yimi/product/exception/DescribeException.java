package com.yimi.product.exception;

import com.yimi.product.enums.ExceptionEnum;

public class DescribeException extends RuntimeException{
    //错误状态码
    private Integer code;

    //利用定义的枚举类初始化
    public DescribeException(ExceptionEnum exceptionEnum) {
        super(exceptionEnum.getMsg());
        this.code = exceptionEnum.getCode();
    }

    //自定义异常
    public DescribeException(String message, Integer code) {
        super(message);
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
