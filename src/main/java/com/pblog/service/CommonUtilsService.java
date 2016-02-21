package com.pblog.service;

import com.pblog.service.article.ArticleInfoVO;
import com.pblog.domain.ArticleInfo;

public interface CommonUtilsService {

    ArticleInfoVO transArticleInfoVO(ArticleInfo articleInfo);
}
