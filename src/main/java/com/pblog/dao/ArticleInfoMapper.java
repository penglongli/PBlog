package com.pblog.dao;

import com.pblog.core.orm.PageRequest;
import com.pblog.domain.ArticleInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ArticleInfoMapper {

    int insert(ArticleInfo articleInfo);

    List<ArticleInfo> findList();

    List<ArticleInfo> findListByCategorySlug(Long categorySlug);

    List<ArticleInfo> findTopTenByCreateTimeDesc();

    ArticleInfo findBySlug(Long slug);

    ArticleInfo findById(Integer id);

    List<ArticleInfo> page(PageRequest pageRequest);

    List<ArticleInfo> findByCreateTimeDesc();

    int update(ArticleInfo articleInfo);

    List<ArticleInfo> findArticleListByMonth(@Param("startTime") Date startTime, @Param("endTime") Date endTime);
}