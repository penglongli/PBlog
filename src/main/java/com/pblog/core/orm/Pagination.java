package com.pblog.core.orm;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

public class Pagination<T> extends PageRequest implements Iterable<T>, Serializable {
    protected List<T> items = null;

    public Pagination(){}

    public Pagination(PageRequest pageRequest){
        this.pageNo = pageRequest.getPageNo();
        this.pageSize = pageRequest.getPageSize();
        this.orderBy = pageRequest.getOrderBy();
        this.orderDir = pageRequest.getOrderDir();
        this.offset = pageRequest.getOffset();
        this.totalCount = pageRequest.getTotalCount();
        this.totalPage = pageRequest.getTotalPage();
    }

    public Iterator<T> iterator() {
        return items.iterator();
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }
}
