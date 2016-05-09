package com.pblog.dao;

import com.pblog.domain.PicInfo;

public interface PicInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PicInfo record);

    int insertSelective(PicInfo record);

    PicInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PicInfo record);

    int updateByPrimaryKey(PicInfo record);
}