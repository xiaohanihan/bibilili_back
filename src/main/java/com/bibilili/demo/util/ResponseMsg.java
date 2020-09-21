package com.bibilili.demo.util;

import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * @program: bibilili
 * @description: 返回的类
 * @author: han.zhang
 * @create: 2020/09/04 09:25
 */
@Data
public class ResponseMsg {
    /**
     * 是否成功
     */
    private boolean success;
    /**
     * 返回的消息
     */
    private String message;
    /**
     * 返回的对象
     */
    private Map<String,Object> resultMap;
    /**
     * 返回的对象
     */
    private List<?> objectList;

    public ResponseMsg(){
        this.success = true;
    }

    public ResponseMsg(boolean isSuccess, String message){
        this.success = isSuccess;
        this.message = message;
    }

    public ResponseMsg(boolean isSuccess, String message,Map<String,Object> map){
        this.success = isSuccess;
        this.message = message;
        this.resultMap = map;
    }

    public ResponseMsg(boolean isSuccess, String message,List<?> list){
        this.success = isSuccess;
        this.message = message;
        this.objectList = list;
    }
}