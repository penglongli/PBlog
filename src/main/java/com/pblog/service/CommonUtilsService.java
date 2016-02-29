package com.pblog.service;

import com.pblog.domain.ArticleInfo;
import com.pblog.service.article.ArticleInfoVO;
import com.pblog.service.article.SimpleArticleInfoVO;

public interface CommonUtilsService {

    ArticleInfoVO transArticleInfoVO(ArticleInfo articleInfo);

    SimpleArticleInfoVO transArticleToSimpleArticle(ArticleInfo articleInfo);
}
