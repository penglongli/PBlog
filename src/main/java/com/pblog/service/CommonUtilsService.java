package com.pblog.service;

import com.pblog.service.article.ArticleInfoVO;
import com.pblog.domain.ArticleInfo;
import com.pblog.service.article.SimpleArticleInfoVO;

import java.util.List;

public interface CommonUtilsService {

    ArticleInfoVO transArticleInfoVO(ArticleInfo articleInfo);

    public List<SimpleArticleInfoVO> transArticleToSimpleArticle(Long categorySlug);
}
