package com.pblog.dao;

import com.pblog.domain.CategoryInfo;

public interface CategoryInfoMapper {

    CategoryInfo findBySlug(Long slug);
}