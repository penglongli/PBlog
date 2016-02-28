package com.pblog.service.archives;

import com.pblog.core.utils.DateFormatUtils;
import com.pblog.dao.ArticleInfoMapper;
import com.pblog.domain.ArticleInfo;
import com.pblog.service.CommonUtilsService;
import com.pblog.service.article.SimpleArticleInfoVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        List<ArchivesVO> archivesVOList = new ArrayList<ArchivesVO>();

        String tempStamp = DateFormatUtils.formatToYearMonth(articleInfoList.get(0).getCreateTime());
        ArchivesVO archivesVO = new ArchivesVO();
        Map<String, SimpleArticleInfoVO> simpleArticleMap = new HashMap<String, SimpleArticleInfoVO>();

        for(ArticleInfo articleInfo : articleInfoList){
            if(tempStamp.equals(DateFormatUtils.formatToYearMonth(articleInfo.getCreateTime()))){
                archivesVO.setTimeStamp(tempStamp);
                //simpleArticleMap.put(DateFormatUtils.formatToDay(articleInfo.getCreateTime()), commonUtilsService.transArticleToSimpleArticle());
                String key = DateFormatUtils.formatToDay(articleInfo.getCreateTime());
                SimpleArticleInfoVO value = commonUtilsService.transArticleToSimpleArticle(articleInfo);
            }
        }


        return archivesVOList;
    }
}
