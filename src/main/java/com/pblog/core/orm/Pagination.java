package com.pblog.core.orm;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

public class Pagination<T> extends PageRequest implements Iterable<T>, Serializable {
    protected List<T> items = null;
    protected long totalCount = -1;

    private int pageNo;

    private int pageSize;

    private String orderBy;

    private String orderDir = Sort.DESC;

    public Pagination(){}

    public Pagination(PageRequest pageRequest){
        this.pageNo = pageRequest.getPageNo();
        this.pageSize = pageRequest.getPageSize();
        this.orderBy = pageRequest.getOrderBy();
        this.orderDir = pageRequest.getOrderDir();
    }

    /**
     * 是否还有下一页.
     */
    public boolean hasNextPage() {
        return (getPageNo() + 1 <= getTotalPages());
    }

    /**
     * 是否最后一页.
     */
    public boolean isLastPage() {
        return !hasNextPage();
    }

    public Iterator<T> iterator() {
        return items.iterator();
    }

    public int getTotalPages(){
        return (int) Math.ceil((double) totalCount / (double) getPageSize());
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    public long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(long totalCount) {
        this.totalCount = totalCount;
    }
}
