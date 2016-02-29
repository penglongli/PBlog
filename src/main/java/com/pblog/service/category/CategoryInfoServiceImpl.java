package com.pblog.service.category;

import com.google.common.collect.Lists;
import com.pblog.dao.ArticleInfoMapper;
import com.pblog.dao.CategoryInfoMapper;
import com.pblog.domain.ArticleInfo;
import com.pblog.domain.CategoryInfo;
import com.pblog.service.CommonUtilsService;
import com.pblog.service.article.ArticleInfoVO;
import com.pblog.service.article.SimpleArticleInfoVO;

import javax.annotation.Resource;
import java.util.List;

public class CategoryInfoServiceImpl implements CategoryInfoService{

    @Resource
    private CategoryInfoMapper categoryInfoMapper;

    @Resource
    private ArticleInfoMapper articleInfoMapper;

    @Resource(name = "commonUtilsService")
    private CommonUtilsService commonUtilsService;

    public List<ArticleInfoVO> findArticleListByCategory(Long categorySlug) {
        List<ArticleInfoVO> articleInfoVOList = Lists.newArrayList();
        List<ArticleInfo> articleInfoList = articleInfoMapper.findListByCategorySlug(categorySlug);

        for(ArticleInfo articleInfo : articleInfoList){
            ArticleInfoVO articleInfoVO = commonUtilsService.transArticleInfoVO(articleInfo);
            articleInfoVOList.add(articleInfoVO);
        }

        return articleInfoVOList;
    }

    public List<CategoryInfoVO> findAll() {
        List<CategoryInfoVO> categoryInfoVOList = Lists.newArrayList();
        List<CategoryInfo> categoryInfoList = categoryInfoMapper.findAll();

        for(CategoryInfo categoryInfo : categoryInfoList){
            CategoryInfoVO categoryInfoVO = new CategoryInfoVO();

            categoryInfoVO.setCategoryTitle(categoryInfo.getTitle());
            categoryInfoVO.setSlug(categoryInfo.getSlug());

            List<SimpleArticleInfoVO> simpleArticleInfoVOList = Lists.newArrayList();
            List<ArticleInfo> articleInfoList = articleInfoMapper.findListByCategorySlug(categoryInfo.getSlug());
            for(ArticleInfo articleInfo : articleInfoList){
                simpleArticleInfoVOList.add(commonUtilsService.transArticleToSimpleArticle(articleInfo));
            }
            categoryInfoVO.setSimpleArticleInfoVOList(simpleArticleInfoVOList);
        }
        return categoryInfoVOList;
    }


}
