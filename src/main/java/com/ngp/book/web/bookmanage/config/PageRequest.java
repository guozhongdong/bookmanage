package com.ngp.book.web.bookmanage.config;

import lombok.Data;

/**
 * @author gzd
 * @date 2020/4/4 下午11:00
 */
@Data
public class PageRequest {

    private int page;

    private int size;

    private int offset;

    public PageRequest() {
    }

    public int getPage() {
        return this.page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return this.size;
    }

    public void setPageSize(int pageSize) {
        this.size = pageSize;
    }

    public long getOffset() {
        return (long)(this.page - 1) * (long)this.size;
    }


}
