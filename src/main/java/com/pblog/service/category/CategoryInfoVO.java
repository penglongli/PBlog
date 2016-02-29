package com.pblog.service.category;

import com.pblog.service.article.SimpleArticleInfo;

import java.util.List;

public class CategoryInfoVO {

    private Long slug;

    private String categoryTitle;

    private List<SimpleArticleInfo> simpleArticleInfoList;

    public Long getSlug() {
        return slug;
    }

    public void setSlug(Long slug) {
        this.slug = slug;
    }

    public String getCategoryTitle() {
        return categoryTitle;
    }

    public void setCategoryTitle(String categoryTitle) {
        this.categoryTitle = categoryTitle;
    }

    public List<SimpleArticleInfo> getSimpleArticleInfoList() {
        return simpleArticleInfoList;
    }

    public void setSimpleArticleInfoList(List<SimpleArticleInfo> simpleArticleInfoList) {
        this.simpleArticleInfoList = simpleArticleInfoList;
    }
}
