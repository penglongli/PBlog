package com.pblog.service.category;

import com.pblog.service.article.ArticleInfoVO;
import com.pblog.service.article.SimpleArticleInfo;

import java.util.List;

public class CategoryInfoVO {

    private Long slug;

    private String categoryTitle;

    private List<ArticleInfoVO> articleInfoVOList;

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

    public List<ArticleInfoVO> getArticleInfoVOList() {
        return articleInfoVOList;
    }

    public void setArticleInfoVOList(List<ArticleInfoVO> articleInfoVOList) {
        this.articleInfoVOList = articleInfoVOList;
    }
}
