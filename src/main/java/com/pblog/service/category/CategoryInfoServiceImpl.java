package com.pblog.service.category;

import com.pblog.dao.ArticleInfoMapper;
import com.pblog.dao.CategoryInfoMapper;
import com.pblog.domain.ArticleInfo;
import com.pblog.domain.CategoryInfo;
import com.pblog.service.CommonUtilsService;
import com.pblog.service.article.ArticleInfoVO;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

public class CategoryInfoServiceImpl implements CategoryInfoService{

    @Resource
    private CategoryInfoMapper categoryInfoMapper;

    @Resource
    private ArticleInfoMapper articleInfoMapper;

    @Resource(name = "commonUtilsService")
    private CommonUtilsService commonUtilsService;

    public List<ArticleInfoVO> findArticleListByCategory(Long categorySlug) {
        List<ArticleInfoVO> articleInfoVOList = new ArrayList<ArticleInfoVO>();
        List<ArticleInfo> articleInfoList = articleInfoMapper.findListByCategorySlug(categorySlug);

        for(ArticleInfo articleInfo : articleInfoList){
            ArticleInfoVO articleInfoVO = commonUtilsService.transArticleInfoVO(articleInfo);
            articleInfoVOList.add(articleInfoVO);
        }

        return articleInfoVOList;
    }

    public List<CategoryInfoVO> findAll() {
        List<CategoryInfoVO> categoryInfoVOList = new ArrayList<CategoryInfoVO>();
        List<CategoryInfo> categoryInfoList = categoryInfoMapper.findAll();

        for(CategoryInfo categoryInfo : categoryInfoList){
            CategoryInfoVO categoryInfoVO = new CategoryInfoVO();

            categoryInfoVO.setCategoryTitle(categoryInfo.getTitle());
            categoryInfoVO.setSlug(categoryInfo.getSlug());
            categoryInfoVO.setSimpleArticleInfoVOList(transArticleToSimpleArticle(categoryInfo.getSlug()));
        }
        return categoryInfoVOList;
    }

    private List<SimpleArticleInfoVO> transArticleToSimpleArticle(Long categorySlug){
        List<SimpleArticleInfoVO> simpleArticleInfoVOList = new ArrayList<SimpleArticleInfoVO>();

        List<ArticleInfo> articleInfoList = articleInfoMapper.findListByCategorySlug(categorySlug);
        for(ArticleInfo articleInfo : articleInfoList){
            SimpleArticleInfoVO simpleArticleInfoVO = new SimpleArticleInfoVO();

            simpleArticleInfoVO.setCreateTime(articleInfo.getCreateTime());
            simpleArticleInfoVO.setSlug(articleInfo.getSlug());
            simpleArticleInfoVO.setTitle(articleInfo.getTitle());
            simpleArticleInfoVOList.add(simpleArticleInfoVO);
        }

        return simpleArticleInfoVOList;

    }
}
