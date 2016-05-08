package com.pblog.dao;

import com.pblog.domain.BookReadLog;

public interface BookReadLogMapper {
    int insert(BookReadLog record);

    BookReadLog selectByPrimaryKey(Long id);

    Long selectNumById(Integer id);
}