package com.pblog.dao;

import com.pblog.domain.BookTable;

import java.util.List;

public interface BookTableMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BookTable record);

    BookTable selectByPrimaryKey(Integer id);

    int updateByPrimaryKey(BookTable record);

    List<BookTable> selectAll();
}