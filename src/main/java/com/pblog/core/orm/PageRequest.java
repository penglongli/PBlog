package com.pblog.core.orm;

public class PageRequest {

    protected int pageNo = 1;

    protected int pageSize = 10;

    protected String orderBy = "id";

    protected String orderDir = Sort.DESC;

    public PageRequest(){}

    public PageRequest(int pageNo, int pageSize){
        this.pageNo = pageNo;
        this.pageSize = pageSize;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;

        if(pageNo < 1){
            this.pageNo = 1;
        }
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;

        if(pageSize < 1){
            this.pageSize = 1;
        }
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public String getOrderDir() {
        return orderDir;
    }

    public void setOrderDir(String orderDir) {
        this.orderDir = orderDir;
    }

    public static class Sort{
        public static final String ASC = "asc";

        public static final String DESC = "desc";

    }
}
