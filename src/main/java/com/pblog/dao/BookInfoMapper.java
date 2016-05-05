package com.pblog.dao;

import com.pblog.domain.BookInfo;
import com.sun.tools.javac.util.List;

public interface BookInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BookInfo record);

    BookInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKey(BookInfo record);

    List<BookInfo> selectAll();

    BookInfo selectBySlug(Long slug);
}