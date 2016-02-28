package com.pblog.dao;

import com.pblog.core.orm.PageRequest;
import com.pblog.core.orm.Pagination;
import com.pblog.domain.ArticleInfo;

import java.util.List;

public interface ArticleInfoMapper {

    int insert(ArticleInfo articleInfo);

    List<ArticleInfo> findList(Pagination<ArticleInfo> pagination);

    List<ArticleInfo> findListByCategorySlug(Long categorySlug);

    int updateArticleEnabled(int articleId, Boolean enabled);

    List<ArticleInfo> findTopTenByCreateTimeDesc();

    ArticleInfo findBySlug(Long slug);

    List<ArticleInfo> page(PageRequest pageRequest);

    List<ArticleInfo> findByCreateTimeDesc();
}