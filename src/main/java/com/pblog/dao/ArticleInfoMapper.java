package com.pblog.dao;

import com.pblog.core.orm.PageRequest;
import com.pblog.domain.ArticleInfo;

import java.util.List;

public interface ArticleInfoMapper {

    int insert(ArticleInfo articleInfo);

    List<ArticleInfo> findList(PageRequest pageRequest);

    List<ArticleInfo> findListByCategorySlug(Long categorySlug);

    int updateArticleEnabled(int articleId, Boolean enabled);

    List<ArticleInfo> findTopTenByCreateTimeDesc();

    ArticleInfo findBySlug(Long slug);

    List<ArticleInfo> pageByPageRequest(PageRequest pageRequest);

}