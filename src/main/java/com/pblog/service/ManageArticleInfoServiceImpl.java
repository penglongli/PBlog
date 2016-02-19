package com.pblog.service;

import com.pblog.core.markdown.GenerateHtml;
import com.pblog.dao.ArticleInfoMapper;
import com.pblog.domain.ArticleInfo;
import com.pblog.web.controller.articlemanage.ArticleInfoFormBean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service("manageArticleInfoService")
@Transactional
public class ManageArticleInfoServiceImpl implements ManageArticleInfoService{

    @Resource
    private ArticleInfoMapper articleInfoMapper;

    public void insert(ArticleInfoFormBean articleInfoFormBean) {
        ArticleInfo articleInfo = transFormBeanToArticle(articleInfoFormBean);

        articleInfoMapper.insert(articleInfo);
        System.out.println(articleInfo.getId());
    }

    public List<ArticleInfo> findListByCategorySlug(Long categorySlug) {
        List<ArticleInfo> articleInfoList;
        if (null == categorySlug){
            articleInfoList = articleInfoMapper.findList();
        }else{
            articleInfoList = articleInfoMapper.findListByCategorySlug(categorySlug);
        }

        return articleInfoList;
    }

    public int updateArticleEnabled(int articleId, boolean enabled) {
        articleInfoMapper.updateArticleEnabled(articleId, enabled);
        return 0;
    }




    private ArticleInfo transFormBeanToArticle(ArticleInfoFormBean articleInfoFormBean){
        ArticleInfo articleInfo = new ArticleInfo();

        articleInfo.setCategorySlug(articleInfoFormBean.getCategorySlug());
        articleInfo.setContent(articleInfoFormBean.getContent());
        articleInfo.setTag(articleInfoFormBean.getTag());
        articleInfo.setTitle(articleInfoFormBean.getTitle());
        articleInfo.setEnabled(true);
        articleInfo.setLastModifyTime(new Date());
        articleInfo.setCreateTime(new Date());
        articleInfo.setThumb(0);

        String html = GenerateHtml.markdownToHTML(articleInfoFormBean.getContent());
        articleInfo.setMarkdown(html);
        html = GenerateHtml.markdownToHTML(articleInfoFormBean.getDescription());
        articleInfo.setDescription(html);

        return articleInfo;
    }
}
