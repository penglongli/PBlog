package com.pblog.dao;

public interface ArticleReadLogMapper {

    Long queryForClickNumByArticle(Integer articleId);
}