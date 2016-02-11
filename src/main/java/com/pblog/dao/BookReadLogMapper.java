package com.pblog.dao;

import com.pblog.domain.BookReadLog;

public interface BookReadLogMapper {
    int deleteByPrimaryKey(Long id);

    int insert(BookReadLog record);

    int insertSelective(BookReadLog record);

    BookReadLog selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(BookReadLog record);

    int updateByPrimaryKey(BookReadLog record);
}