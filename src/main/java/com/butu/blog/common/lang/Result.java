package com.butu.blog.common.lang;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @author BUTUbird
 */
@Data
public class Result {
    /**
     * 返回状态 成功 失败
     */
    private boolean status;
    /**
     * 返回状态码
     */
    private String code;
    /**
     * 返回信息
     */
    private String message;
    /**
     * 返回数据
     */
    Map<String,Object> data = new HashMap<>();


    public static Result success(){
        Result result = new Result();
        result.status = true;
        return result;
    }
    public static Result error(){
        Result result = new Result();
        result.status = false;
        return result;
    }
    public  Result code(String code){
        this.setCode(code);
        return this;
    }
    public  Result message(String message){
        this.setMessage(message);
        return this;
    }
    public  Result codeAndMessage(String code, String message){
        this.setCode(code);
        this.setMessage(message);
        return this;
    }
    public  Result codeAndMessage(ResultInfo resultInfo){
        this.setCode(resultInfo.getCode());
        this.setMessage(resultInfo.getMessage());
        return this;
    }

    /**
     *
     * @param key 对象名
     * @param value 对象值
     * @return null
     */
    public Result data(String key,Object value){
        this.data.put(key,value);
        return this;
    }
}
