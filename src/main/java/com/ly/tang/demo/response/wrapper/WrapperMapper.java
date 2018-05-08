package com.ly.tang.demo.response.wrapper;

import com.ly.tang.demo.response.ResponseCode;

/**
 * @author tangmingjian 2018-04-28 上午11:29
 **/
public class WrapperMapper {

    private WrapperMapper() {
    }

    public static <D> Wrapper<D> wrap(int code, String msg, D d) {
        return new Wrapper<>(code, msg, d);
    }

    public static <D> Wrapper<D> ok(D d) {
        return new Wrapper<>(ResponseCode.SUCCESS, d);
    }

    public static <D> Wrapper<D> error() {
        return new Wrapper<>(ResponseCode.ERROR, null);
    }

    public static <D> Wrapper<D> illegalParams() {
        return new Wrapper<>(ResponseCode.PARAMS_ERROR, null);
    }
}
