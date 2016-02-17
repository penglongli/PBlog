package com.pblog.service.article;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface ArticleInfoService {

    List<ArticleInfoVO> findTopTenArticlesByCreateTime();

    ArticleInfoVO findArticleBySlug(Long slug, HttpServletRequest request);
}
