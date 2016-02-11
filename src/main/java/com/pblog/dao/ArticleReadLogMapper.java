package com.pblog.dao;

import com.pblog.domain.ArticleReadLog;

public interface ArticleReadLogMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ArticleReadLog record);

    int insertSelective(ArticleReadLog record);

    ArticleReadLog selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ArticleReadLog record);

    int updateByPrimaryKey(ArticleReadLog record);
}