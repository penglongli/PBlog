package com.pblog.dao;

import com.pblog.domain.ArticleReadLog;

public interface ArticleReadLogMapper {

    Long queryForClickNumByArticle(Integer articleId);

    void insert(ArticleReadLog articleReadLog);
}