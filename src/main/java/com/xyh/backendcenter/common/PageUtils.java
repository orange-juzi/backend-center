package com.xyh.backendcenter.common;

import lombok.Data;
import java.io.Serializable;
import java.util.List;

@Data
public class PageUtils implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 总记录数
     */
    private long total;
    /**
     * 每页记录数
     */
    private int pageSize;
    /**
     * 总页数
     */
    private int totalPage;
    /**
     * 当前页数
     */
    private int currentPage;
    /**
     * 列表数据
     */
    private List<?> list;

    public PageUtils(List<?> list, long total, int currentPage, int pageSize) {
        this.list = list;
        this.total = total;
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.totalPage = (int) Math.ceil((double) total / pageSize);
    }

}
