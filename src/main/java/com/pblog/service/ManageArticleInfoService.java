package com.pblog.service;

import com.pblog.domain.ArticleInfo;
import com.pblog.web.controller.articlemanage.ArticleInfoFormBean;

import java.util.List;

public interface ManageArticleInfoService {

    void insert(ArticleInfoFormBean articleInfoFormBean);

    List<ArticleInfo> findListByCategorySlug(Long categorySlug);

    int updateArticleEnabled(int articleId, boolean enabled);


}
