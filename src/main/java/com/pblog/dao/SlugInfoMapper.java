package com.pblog.dao;

import com.pblog.domain.SlugInfo;

public interface SlugInfoMapper {

    int insert(SlugInfo record);

    SlugInfo queryById(Integer id);
}