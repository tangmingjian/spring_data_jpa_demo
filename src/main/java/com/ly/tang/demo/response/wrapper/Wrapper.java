package com.ly.tang.demo.response.wrapper;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.ly.tang.demo.response.ResponseCode;
import lombok.Data;

import java.io.Serializable;

/**
 * @author tangmingjian 2018-04-28 上午10:55
 **/
@Data
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class Wrapper<D> implements Serializable {

    private int code;

    private String msg;

    private D data;


    Wrapper(int code, String msg) {
        code(code).msg(msg);
    }

    Wrapper(int code, String msg, D data) {
        code(code).msg(msg).data(data);
    }

    Wrapper(ResponseCode code, D data) {
        this(code.getCode(), code.getDescription(), data);
    }


    private Wrapper<D> code(int code) {
        this.setCode(code);
        return this;
    }

    private Wrapper<D> msg(String msg) {
        this.setMsg(msg);
        return this;
    }

    private Wrapper<D> data(D data) {
        this.setData(data);
        return this;
    }
}
