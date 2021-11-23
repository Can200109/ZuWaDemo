package com.example.zuwademo.enums;

import lombok.Getter;

@Getter
public enum ResultEnum {
    //运行发生错误
    ERROR(500, "程序发生异常"),
    //运行成功
    SUCCESS(200, "成功");

    /*错误码*/
    Integer code;
    /*错误信息*/
    String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
