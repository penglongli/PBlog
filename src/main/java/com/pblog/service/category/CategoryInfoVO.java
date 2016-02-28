package com.pblog.service.category;

import com.pblog.service.article.SimpleArticleInfoVO;

import java.util.List;

public class CategoryInfoVO {

    private Long slug;

    private String categoryTitle;

    private List<SimpleArticleInfoVO> simpleArticleInfoVOList;

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

    public List<SimpleArticleInfoVO> getSimpleArticleInfoVOList() {
        return simpleArticleInfoVOList;
    }

    public void setSimpleArticleInfoVOList(List<SimpleArticleInfoVO> simpleArticleInfoVOList) {
        this.simpleArticleInfoVOList = simpleArticleInfoVOList;
    }
}
