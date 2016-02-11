package com.pblog.dao;

import com.pblog.domain.BookInfo;

public interface BookInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BookInfo record);

    int insertSelective(BookInfo record);

    BookInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BookInfo record);

    int updateByPrimaryKeyWithBLOBs(BookInfo record);

    int updateByPrimaryKey(BookInfo record);
}