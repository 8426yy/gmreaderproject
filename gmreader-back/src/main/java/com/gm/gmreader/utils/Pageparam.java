package com.gm.gmreader.utils;

public class Pageparam
{
    private int pageSize;
    private int pageNum;
    public Pageparam(int pageSize, int pageNum) {
        this.pageSize = pageSize;
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    @Override
    public String toString() {
        return "Pageparam{" +
                "pageSize=" + pageSize +
                ", pageNum=" + pageNum +
                '}';
    }


}
