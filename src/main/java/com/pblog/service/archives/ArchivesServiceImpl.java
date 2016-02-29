package com.pblog.service.archives;

import com.google.common.collect.Lists;
import com.pblog.core.utils.DateFormatUtils;
import com.pblog.dao.ArticleInfoMapper;
import com.pblog.domain.ArticleInfo;
import com.pblog.service.CommonUtilsService;
import com.pblog.service.article.SimpleArticleInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service(value = "archivesService")
@Transactional
public class ArchivesServiceImpl implements ArchivesService{

    @Resource
    private ArticleInfoMapper articleInfoMapper;

    @Resource(name = "commonUtilsService")
    private CommonUtilsService commonUtilsService;

    public List<ArchivesVO> findArchivesList() {
        List<ArticleInfo> articleInfoList = articleInfoMapper.findByCreateTimeDesc();

        return transArchivesVO(articleInfoList);
    }

    private List<ArchivesVO> transArchivesVO(List<ArticleInfo> articleInfoList){
        List<ArchivesVO> archivesVOList = Lists.newArrayList();
        ArchivesVO archivesVO = new ArchivesVO();

        List<SimpleArticleInfo> simpleArticleInfoList = Lists.newArrayList();
        String tempStamp = DateFormatUtils.formatToYearMonth(articleInfoList.get(0).getCreateTime());
        for(ArticleInfo articleInfo : articleInfoList){
            //当前article的时间戳和temp时间戳不一致时
            if(!tempStamp.equals(DateFormatUtils.formatToYearMonth(articleInfo.getCreateTime()))){
                archivesVO.setSimpleArticleList(simpleArticleInfoList);
                archivesVOList.add(archivesVO);

                archivesVO = new ArchivesVO();
                simpleArticleInfoList = Lists.newArrayList();
            }
            SimpleArticleInfo tempArticle = commonUtilsService.transArticleToSimpleArticle(articleInfo);

            archivesVO.setTimeStamp(tempStamp);
            simpleArticleInfoList.add(tempArticle);
        }

        return archivesVOList;
    }

}
