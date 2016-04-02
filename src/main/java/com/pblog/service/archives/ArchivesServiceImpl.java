package com.pblog.service.archives;

import com.google.common.collect.Lists;
import com.pblog.core.utils.DateFormatUtils;
import com.pblog.dao.ArticleInfoMapper;
import com.pblog.domain.ArticleInfo;
import com.pblog.service.CommonUtilsService;
import com.pblog.service.article.ArticleInfoVO;
import com.pblog.service.article.SimpleArticleInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

@Service(value = "archivesService")
@Transactional
public class ArchivesServiceImpl implements ArchivesService{

    @Resource
    private ArticleInfoMapper articleInfoMapper;

    @Resource(name = "commonUtilsService")
    private CommonUtilsService commonUtilsService;

    public List<ArchivesVO> findArchivesList() throws ParseException {
        List<ArticleInfo> articleInfoList = articleInfoMapper.findByCreateTimeDesc();

        return transArchivesVO(articleInfoList);
    }

    public List<ArticleInfoVO> findArticleByMonth(String timeStamp) throws ParseException {
        List<ArticleInfoVO> articleInfoVOList = Lists.newArrayList();

        Date startTime = DateFormatUtils.formatStrToYM(timeStamp);
        Date endTime = DateFormatUtils.addMonth(timeStamp, 1);

        List<ArticleInfo> articleInfoList = articleInfoMapper.findArticleListByMonth(startTime, endTime);
        for(ArticleInfo articleInfo : articleInfoList){
            ArticleInfoVO articleInfoVO = commonUtilsService.transArticleInfoVO(articleInfo);

            articleInfoVOList.add(articleInfoVO);
        }
        return articleInfoVOList;
    }

    private List<ArchivesVO> transArchivesVO(List<ArticleInfo> articleInfoList) throws ParseException {
        List<ArchivesVO> archivesVOList = Lists.newArrayList();
        ArchivesVO archivesVO = new ArchivesVO();

        List<ArticleInfoVO> articleInfoVOList = Lists.newArrayList();
        String tempStamp = DateFormatUtils.formatToYearMonth(articleInfoList.get(0).getCreateTime());
        for(ArticleInfo articleInfo : articleInfoList){
            //当前article的时间戳和temp时间戳不一致时
            String currentStamp = DateFormatUtils.formatToYearMonth(articleInfo.getCreateTime());
            if(!tempStamp.equals(currentStamp)){
                archivesVO.setArticleInfoVOList(articleInfoVOList);
                archivesVOList.add(archivesVO);

                archivesVO = new ArchivesVO();
                tempStamp = currentStamp;
                articleInfoVOList = Lists.newArrayList();
            }
            ArticleInfoVO tempArticle = commonUtilsService.transArticleInfoVO(articleInfo);

            archivesVO.setTimeStamp(DateFormatUtils.formatStrToYM(tempStamp));
            archivesVO.setArticleInfoVOList(articleInfoVOList);
            articleInfoVOList.add(tempArticle);
        }
        archivesVOList.add(archivesVO);

        return archivesVOList;
    }

}
