package com.pblog.service;

import com.pblog.domain.ArticleInfo;
import com.pblog.service.article.ArticleInfoVO;
import com.pblog.service.article.SimpleArticleInfo;

public interface CommonUtilsService {

    ArticleInfoVO transArticleInfoVO(ArticleInfo articleInfo);

    SimpleArticleInfo transArticleToSimpleArticle(ArticleInfo articleInfo);
}
