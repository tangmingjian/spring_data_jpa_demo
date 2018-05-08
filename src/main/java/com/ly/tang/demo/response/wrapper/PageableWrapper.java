package com.ly.tang.demo.response.wrapper;

import com.ly.tang.demo.response.ResponseCode;
import lombok.Data;

/**
 * @author tangmingjian 2018-04-29 下午1:15
 **/
@Data
public class PageableWrapper<D> extends Wrapper<D> {

    private int currPage;

    private int totalPages;

    private boolean hasBefore;

    private boolean hasNext;

    private long size;

    private long totalSize;


    PageableWrapper(int code, String msg, D data, int currPage, int size, int totalSize) {
        super(code, msg, data);
        setPageInfo(currPage, size, totalSize);
    }

    PageableWrapper(ResponseCode code, D data, int currPage, int size, int totalSize) {
        super(code, data);
        setPageInfo(currPage, size, totalSize);
    }

    private void setPageInfo(int currPage, int size, int totalSize) {
        this.currPage = currPage;
        this.size = size;
        this.totalSize = totalSize;
        this.totalPages = totalSize % size == 0 ? totalSize / size : totalSize / size + 1;
        this.hasBefore = currPage > 0 && totalPages > 0;
        this.hasNext = currPage < totalPages;
    }
}
