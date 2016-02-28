package com.pblog.service;

import com.pblog.core.utils.GenerateUtils;
import com.pblog.dao.ArticleInfoMapper;
import com.pblog.dao.ArticleReadLogMapper;
import com.pblog.dao.CategoryInfoMapper;
import com.pblog.domain.ArticleInfo;
import com.pblog.domain.CategoryInfo;
import com.pblog.service.article.ArticleInfoVO;
import com.pblog.service.article.SimpleArticleInfoVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service("commonUtilsService")
@Transactional
public class CommonUtilsServiceImpl implements CommonUtilsService{

    @Resource
    private CategoryInfoMapper categoryInfoMapper;

    @Resource
    private ArticleReadLogMapper articleReadLogMapper;

    @Resource
    private ArticleInfoMapper articleInfoMapper;

    public ArticleInfoVO transArticleInfoVO(ArticleInfo articleInfo) {
        ArticleInfoVO articleInfoVO = new ArticleInfoVO();

        articleInfoVO.setTitle(articleInfo.getTitle());
        articleInfoVO.setDescription(articleInfo.getDescription());
        articleInfoVO.setContent(articleInfo.getContent());
        articleInfoVO.setTags(GenerateUtils.spiltStringByComma(articleInfo.getTag()));
        articleInfoVO.setCreateTime(articleInfo.getCreateTime());
        articleInfoVO.setArticleSlug(articleInfo.getSlug());
        articleInfoVO.setCategorySlug(articleInfo.getCategorySlug());
        articleInfoVO.setLikeNum(articleInfo.getThumb());

        Long categorySlug = articleInfo.getCategorySlug();
        CategoryInfo categoryInfo = categoryInfoMapper.findBySlug(categorySlug);
        articleInfoVO.setCategoryName(categoryInfo.getTitle());

        Long clickNum = articleReadLogMapper.queryForClickNumByArticle(articleInfo.getId());
        articleInfoVO.setReviewNum(clickNum);

        return articleInfoVO;
    }

    public List<SimpleArticleInfoVO> transArticleToSimpleArticle(Long categorySlug){
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
