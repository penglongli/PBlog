package com.pblog.service;


import com.pblog.domain.ArticleInfo;
import com.pblog.service.article.ArticleInfoVO;

public interface CommonUtilsService {

    ArticleInfoVO transArticleInfoVO(ArticleInfo articleInfo);
}
