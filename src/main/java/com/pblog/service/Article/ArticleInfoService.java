package com.pblog.service.Article;

import java.util.List;

public interface ArticleInfoService {

    List<ArticleInfoVO> findTopTenArticlesByCreateTime();
}
