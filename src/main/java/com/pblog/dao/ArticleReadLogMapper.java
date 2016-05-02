package com.pblog.dao;

import com.pblog.domain.ArticleReadLog;

public interface ArticleReadLogMapper {

    int insert(ArticleReadLog record);

    /**
     * 查看文章点击次数
     * @param articleSlug 文章slug
     * @return 点击次数
     */
    Long queryForClickNumByArticle(Long articleSlug);
}