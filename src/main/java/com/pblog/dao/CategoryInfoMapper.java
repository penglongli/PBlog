package com.pblog.dao;

import com.pblog.domain.CategoryInfo;

import java.util.List;

public interface CategoryInfoMapper {

    CategoryInfo findBySlug(Long slug);

    List<CategoryInfo> findAll();
}