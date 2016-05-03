package com.pblog.service.article;

import com.pblog.core.orm.PageRequest;
import com.pblog.core.orm.Pagination;
import com.pblog.core.utils.GenerateUtils;
import com.pblog.dao.ArticleInfoMapper;
import com.pblog.dao.ArticleReadLogMapper;
import com.pblog.dao.CategoryInfoMapper;
import com.pblog.domain.ArticleInfo;
import com.pblog.domain.ArticleReadLog;
import com.pblog.service.CommonUtilsService;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service(value = "articleInfoService")
@Transactional
public class ArticleInfoServiceImpl implements ArticleInfoService{

    @Resource
    private ArticleInfoMapper articleInfoMapper;

    @Resource
    private ArticleReadLogMapper articleReadLogMapper;

    @Resource(name = "commonUtilsService")
    private CommonUtilsService commonUtilsService;

/*
    public List<ArticleInfoVO> findTopTenArticlesByCreateTime() {

        List<ArticleInfoVO> articleInfoVOList = new ArrayList<ArticleInfoVO>();
        List<ArticleInfo> articleInfoList = articleInfoMapper.findTopTenByCreateTimeDesc();

        for(ArticleInfo articleInfo : articleInfoList){
            ArticleInfoVO articleInfoVO = commonUtilsService.transArticleInfoVO(articleInfo);
            articleInfoVOList.add(articleInfoVO);
        }

        return articleInfoVOList;
    }
*/

    public ArticleInfoVO findArticleBySlug(Long slug, String ipAddress) {
        ArticleInfo articleInfo = articleInfoMapper.findBySlug(slug);

        ArticleInfoVO articleInfoVO = commonUtilsService.transArticleInfoVO(articleInfo);
        articleInfoVO = (articleInfoVO == null ? new ArticleInfoVO() : articleInfoVO);
        insertArticleReadLog(ipAddress, articleInfo.getSlug(), ArticleReadLog.ArticleReadType.TYPE_READ.getId());

        return articleInfoVO;
    }

    public Pagination<ArticleInfoVO> page(PageRequest pageRequest, HttpServletRequest request) {
        List<ArticleInfo> articleInfoList = articleInfoMapper.page(pageRequest);
        Pagination<ArticleInfoVO> pagination = new Pagination<ArticleInfoVO>(pageRequest);

        List<ArticleInfoVO> articleInfoVOList = new ArrayList<ArticleInfoVO>();
        for(ArticleInfo articleInfo : articleInfoList){
            ArticleInfoVO articleInfoVO = commonUtilsService.transArticleInfoVO(articleInfo);
            articleInfoVOList.add(articleInfoVO);
        }

        //分页第一篇文章会被浏览，则增加点击记录
        String ipAddress = (String) request.getAttribute("realIp");
        Long slug = articleInfoVOList.get(0).getArticleSlug();
        insertArticleReadLog(ipAddress, slug, ArticleReadLog.ArticleReadType.TYPE_READ.getId());

        pagination.setItems(articleInfoVOList);
        return pagination;
    }

    /**
     * 插入文章点击记录
     * @param ipAddress 地址
     * @param articleInfoSlug 文章slug
     * @param type 记录类型
     */
    private void insertArticleReadLog(String ipAddress, Long articleInfoSlug, Integer type) {
        ArticleReadLog articleReadLog = new ArticleReadLog();

        articleReadLog.setArticleSlug(articleInfoSlug);
        articleReadLog.setIpAddress(ipAddress);
        articleReadLog.setType(type);
        articleReadLogMapper.insert(articleReadLog);
    }


}
