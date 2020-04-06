package com.ngp.book.web.bookmanage.config;




import java.util.ArrayList;
import java.util.List;

/**
 * @author gzd
 * @date 2020/4/4 下午11:09
 */
public class PageInfo {

    private boolean success = true;
    private String message;
    private Integer pageNo;
    private Integer pageSize;
    private List pageObjectList = new ArrayList();

    private Integer total = 0;

    private Integer totalPages = 0;

    public PageInfo() {
    }

    public PageInfo(boolean success, String message, Integer pageNo, Integer pageSize, List pageObjectList, Integer total) {
        this.success = success;
        this.message = message;
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        this.total = total;
        setPageObjectList(pageObjectList);

        calculateTotalPages();
    }

    public PageInfo(boolean success, String message, List pageObjectList) {
        this(success, message, 0, 0, pageObjectList, 0);
    }

    public boolean isSuccess() {
        return this.success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getPageNo() {
        return this.pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return this.pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotal() {
        return this.total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getTotalPages() {
        return this.totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public List getPageObjectList() {
        return this.pageObjectList;
    }

    public void setPageObjectList(List pageObjectList) {
        this.pageObjectList = pageObjectList;
    }

    private void calculateTotalPages() {
        if (this.pageSize < 1) {
            this.pageSize = 20;
        }
        if (this.total > 0) {
            this.totalPages = (this.total + this.pageSize - 1) / this.pageSize;
        }
    }



}
