package com.ly.tang.demo.response;

/**
 * @author tangmingjian 2018-04-28 上午10:56
 **/
public enum ResponseCode {

    SUCCESS(200, "成功"),

    PARAMS_ERROR(400, "参数错误"),

    ERROR(500, "系统异常");

    private int code;

    private String description;

    ResponseCode(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
}
