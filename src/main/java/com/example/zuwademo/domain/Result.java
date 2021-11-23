package com.example.zuwademo.domain;

import lombok.Data;

@Data
public class Result<T> {
    /**
     * 错误码
     **/
    private Integer code;

    /**
     * 错误信息
     */
    private String msg;

    private T data;
}
