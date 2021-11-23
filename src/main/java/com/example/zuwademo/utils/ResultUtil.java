package com.example.zuwademo.utils;

import com.example.zuwademo.domain.Result;
import com.example.zuwademo.enums.ResultEnum;

public class ResultUtil {

    public static <T> Result success(Integer code,
                                     String msg,
                                     T data) {
        Result<T> result = new Result<>();
        result.setData(data);
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

    public static <T> Result success(Integer code,
                                     T data) {
        Result<T> result = new Result<>();
        result.setData(data);
        result.setCode(code);
        result.setMsg(ResultEnum.SUCCESS.getMsg());
        return result;
    }

    public static <T> Result success(T data) {
        Result<T> result = new Result<>();
        result.setData(data);
        result.setCode(ResultEnum.SUCCESS.getCode());
        result.setMsg(ResultEnum.SUCCESS.getMsg());
        return result;
    }

    public static Result error(Integer code, String msg) {
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(null);
        return result;
    }

    public static Result error(String msg) {
        Result result = new Result();
        result.setCode(ResultEnum.ERROR.getCode());
        result.setMsg(msg);
        result.setData(null);
        return result;
    }
}
