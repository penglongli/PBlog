package com.pblog.dao;

import com.pblog.domain.ArticleInfo;

public interface ArticleInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ArticleInfo record);

    int insertSelective(ArticleInfo record);

    ArticleInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ArticleInfo record);

    int updateByPrimaryKey(ArticleInfo record);
}