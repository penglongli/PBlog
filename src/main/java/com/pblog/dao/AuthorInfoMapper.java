package com.pblog.dao;

import com.pblog.domain.AuthorInfo;

public interface AuthorInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AuthorInfo record);

    int insertSelective(AuthorInfo record);

    AuthorInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AuthorInfo record);

    int updateByPrimaryKey(AuthorInfo record);
}