package com.pblog.dao;

import com.pblog.domain.ArticleInfo;

import java.util.List;

public interface ArticleInfoMapper {

    int insert(ArticleInfo articleInfo);

    List<ArticleInfo> findList();

    List<ArticleInfo> findListByCategorySlug(Long categorySlug);

    int updateArticleEnabled(int articleId, Boolean enabled);

    List<ArticleInfo> findTopTenByCreateTimeDesc();

    ArticleInfo findBySlug(Long slug);
}