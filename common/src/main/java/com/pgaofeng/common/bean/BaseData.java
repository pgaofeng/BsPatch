package com.pgaofeng.common.bean;

/**
 * @author gaofengpeng
 * @date 2019/3/25
 * @description : 获取数据返回的基本类型
 */
public class BaseData<T> {
    /**
     * 返回码
     */
    private int code;
    /**
     * 返回提示消息
     */
    private String message;
    /**
     * 返回的实际数据内容
     */
    private T data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
