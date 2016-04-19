package com.pblog.dao;

import com.pblog.domain.ArticleReadLog;

public interface ArticleReadLogMapper {

    int insert(ArticleReadLog record);

    Long queryForClickNumByArticle(Long articleSlug);
}