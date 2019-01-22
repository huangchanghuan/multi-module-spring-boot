package com.yimi.product.dto;

/**
 * @author Peter  2016-9-3下午5:35:45
 */
//所有ajax请求返回的类型，封装json结果
public class ServiceResult<T> {

    private boolean success;//通信是否成功

    private T data;//消息内容

    private String code;

    public ServiceResult(boolean success, T data) {
        super();
        this.success = success;
        this.data = data;
    }
    public ServiceResult(boolean success, T data,String code) {
        super();
        this.success = success;
        this.data = data;
        this.code=code;
    }
    public ServiceResult(boolean success, String code) {
        super();
        this.success = success;
        this.code = code;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getError() {
        return code;
    }

    public void setError(String code) {
        this.code = code;
    }


}
