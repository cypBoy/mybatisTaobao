package com.icss.entity;

import java.util.List;

/**
 *
 * @author dell
 * 分页的实体
 */
public class PageUtil<T> {
    /**
     * 当前是第几页
     */
    private int curIndex;
    /**
     * 一页的数量
     */
    private int pageSize;
    /**
     * 总页数
     */
    private int totalPage;

    /**
     * 总数据：
     */
    private int totalNum;
    private List<T>  list;

    public int getCurIndex() {
        return curIndex;
    }

    public void setCurIndex(int curIndex) {
        this.curIndex = curIndex;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public int getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(int totalNum) {
        this.totalNum = totalNum;
    }

    @Override
    public String toString() {
        return "PageUtil [curIndex=" + curIndex + ", pageSize=" + pageSize
                + ", totalPage=" + totalPage + ", totalNum=" + totalNum
                + ", list=" + list + "]";
    }
}
