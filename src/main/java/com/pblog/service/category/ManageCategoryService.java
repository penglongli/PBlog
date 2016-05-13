package com.pblog.service.category;

import com.pblog.domain.CategoryInfo;

import java.util.List;

public interface ManageCategoryService {

    void insert(CategoryInfo categoryInfo);

    List<SimpleCategoryInfo> list();

    int updateBySlug(CategoryInfo categoryInfo);
}
