package com.example.zuwademo.exception;

import lombok.Data;

@Data
public class SystemException extends RuntimeException {
    private Integer code;
    private String msg;

    public SystemException(Integer code, String msg) {
        super(msg);
        this.msg = msg;
        this.code = code;
    }

    public SystemException(String msg) {
        super(msg);
        this.msg = msg;
    }

}
