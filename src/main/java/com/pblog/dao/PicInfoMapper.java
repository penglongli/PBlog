package com.pblog.dao;

import com.pblog.domain.PicInfo;

import java.util.List;

public interface PicInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PicInfo record);

    List<PicInfo> selectAll();

    PicInfo selectById(Long id);
}