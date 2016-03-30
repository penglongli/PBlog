package com.pblog.service.archives;


import com.pblog.service.article.ArticleInfoVO;
import com.pblog.service.article.SimpleArticleInfo;

import java.util.Date;
import java.util.List;

public class ArchivesVO {

    private Date timeStamp;

    List<ArticleInfoVO> articleInfoVOList;

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    public List<ArticleInfoVO> getArticleInfoVOList() {
        return articleInfoVOList;
    }

    public void setArticleInfoVOList(List<ArticleInfoVO> articleInfoVOList) {
        this.articleInfoVOList = articleInfoVOList;
    }
}
