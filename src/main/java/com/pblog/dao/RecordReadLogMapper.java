package com.pblog.dao;

import com.pblog.domain.RecordReadLog;

public interface RecordReadLogMapper {
    int deleteByPrimaryKey(Long id);

    int insert(RecordReadLog record);

    int insertSelective(RecordReadLog record);

    RecordReadLog selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(RecordReadLog record);

    int updateByPrimaryKey(RecordReadLog record);
}