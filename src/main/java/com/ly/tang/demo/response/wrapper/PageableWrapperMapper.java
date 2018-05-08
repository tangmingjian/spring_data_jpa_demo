package com.ly.tang.demo.response.wrapper;

import com.ly.tang.demo.response.ResponseCode;

/**
 * @author tangmingjian 2018-04-29 下午2:10
 **/
public class PageableWrapperMapper {

    private PageableWrapperMapper() {
    }

    public static <D> PageableWrapper<D> ok(D data, int currPage, int size, int totalSize) {
        return new PageableWrapper<D>(ResponseCode.SUCCESS, data, currPage, size, totalSize);
    }

    public static <D> PageableWrapper<D> error() {
        return new PageableWrapper<D>(ResponseCode.ERROR, null, 0, 0, 0);
    }

    public static <D> PageableWrapper<D> illegalParams() {
        return new PageableWrapper<D>(ResponseCode.PARAMS_ERROR, null, 0, 0, 0);
    }
}
