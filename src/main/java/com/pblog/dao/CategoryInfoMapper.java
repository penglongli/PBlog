package com.pblog.dao;

import com.pblog.domain.CategoryInfo;

public interface CategoryInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CategoryInfo record);

    int insertSelective(CategoryInfo record);

    CategoryInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CategoryInfo record);

    int updateByPrimaryKey(CategoryInfo record);
}