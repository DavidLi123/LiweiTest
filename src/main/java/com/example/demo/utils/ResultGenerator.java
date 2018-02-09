package com.example.demo.utils;

import com.example.demo.entity.RestResult;
import com.example.demo.entity.ResultCode;
import org.springframework.stereotype.Component;

/**
 * 工厂模式
 * 接口信息生成工具
 * @Component 加添到spring组件中
 * Created by liw on 2018/02/08.
 */
@Component
public class ResultGenerator {

    private static final String SUCCESS = "success";
    //成功
    public RestResult getSuccessResult(){
        return new RestResult()
                .setCode(ResultCode.SUCCESS)
                .setMessage(SUCCESS);
    }
    //成功，附加额外信息
    public RestResult getSuccessResult(Object data){
        return new RestResult()
                .setCode(ResultCode.SUCCESS)
                .setMessage(SUCCESS)
                .setData(data);
    }
    //成功，自定义消息及数据
    public RestResult getSuccessResult(String message,Object data){
        return  new RestResult()
                .setCode(ResultCode.SUCCESS)
                .setMessage(message)
                .setData(data);
    }
    //失败，附带消息
    public RestResult getFailResult(String message){
        return new RestResult()
                .setCode(ResultCode.FAIL)
                .setData(message);
    }
    //失败，自定义消息及数据
    public RestResult getFailResult(String message, Object data){
        return new RestResult()
                .setCode(ResultCode.FAIL)
                .setMessage(message)
                .setData(data);
    }
    //自定义创建
    public RestResult getFreeResult(ResultCode code, String message, Object data){
        return new RestResult()
                .setCode(code)
                .setMessage(message)
                .setData(data);
    }

}
