package com.example.demo.entity;

/**
 * 统一封装API返回信息
 * 千万别加@Entity否则Hibenate会创建表
 * Created by liw on 2018/02/08.
 */
public class RestResult {
    //状态码
    private Integer code;
    //消息
    private String message;
    //额外的内容
    private Object data;

    public RestResult(){

    }

    public RestResult setCode(ResultCode code){
        this.code = code.getCode();
        return this;
    }

    public int getCode() {
        return code;
    }

    public RestResult setCode(Integer code) {
        this.code = code;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public RestResult setMessage(String message) {
        this.message = message;
        return this;
    }

    public Object getData() {
        return data;
    }

    public RestResult setData(Object data) {
        this.data = data;
        return this;
    }

}
