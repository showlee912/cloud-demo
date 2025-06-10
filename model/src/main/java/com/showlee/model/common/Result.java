package com.showlee.model.common;


import lombok.Data;

@Data
public class Result {

    private Integer code;
    private String msg;
    private Object data;


    public static Result ok() {
        Result result = new Result();
        result.setCode(200);
        return result;
    }

    public static Result ok(String msg, Object data) {
        Result result = new Result();
        result.setCode(200);
        result.setMsg(msg);
        result.setData(data);
        return result;
    }

    public static Result error() {
        Result result = new Result();
        result.setCode(500);
        return result;
    }

    public static Result error(Integer code, String msg){
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}
