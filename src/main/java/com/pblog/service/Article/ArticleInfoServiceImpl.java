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
    private CategoryInfoMapper categoryInfoMapper;

    @Resource
    private ArticleReadLogMapper articleReadLogMapper;

    @Resource
    private SqlSessionFactory sessionFactory;

    @Resource(name = "commonUtilsService")
    private CommonUtilsService commonUtilsService;

    public List<ArticleInfoVO> findTopTenArticlesByCreateTime() {

        List<ArticleInfoVO> articleInfoVOList = new ArrayList<ArticleInfoVO>();
        List<ArticleInfo> articleInfoList = articleInfoMapper.findTopTenByCreateTimeDesc();

        for(ArticleInfo articleInfo : articleInfoList){
            ArticleInfoVO articleInfoVO = commonUtilsService.transArticleInfoVO(articleInfo);
            articleInfoVOList.add(articleInfoVO);
        }

        return articleInfoVOList;
    }

    public ArticleInfoVO findArticleBySlug(Long slug, HttpServletRequest request) {
        ArticleInfo articleInfo = articleInfoMapper.findBySlug(slug);

        ArticleReadLog articleReadLog = new ArticleReadLog();
        articleReadLog.setArticleId(articleInfo.getId());
        articleReadLog.setIpAddress(GenerateUtils.getIpAddr(request));
        articleReadLog.setCreateTime(new Date());
        articleReadLog.setType(ArticleReadLog.TYPE.get("READ"));
        articleReadLogMapper.insert(articleReadLog);

        ArticleInfoVO articleInfoVO = commonUtilsService.transArticleInfoVO(articleInfo);
        return articleInfoVO;
    }

    public Pagination<ArticleInfoVO> page(PageRequest pageRequest) {


        return null;
    }
}
