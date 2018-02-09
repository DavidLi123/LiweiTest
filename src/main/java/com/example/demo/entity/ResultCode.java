package com.example.demo.entity;

/**
 * 状态码枚举，参考HTTP状态码的语义
 * Created by liw on 2018/02/08.
 */
public enum  ResultCode{
    SUCCESS(200),//成功
    FAIL(400),//失败
    UNAUTHORIZED(401),//未认证（签名错误）
    NOT_FOUND(404),//接口不存在
    INTERNAL_SERVER_ERROR(500);//服务器内部错误

    private  int code;

    private ResultCode(int code) {
        this.code = code;
    }

    public int getCode(){
        return this.code;
    }

}
