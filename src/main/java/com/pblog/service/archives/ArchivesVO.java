package com.pblog.service.archives;


import com.pblog.service.article.SimpleArticleInfoVO;

import java.util.List;

public class ArchivesVO {

    private String timeStamp;

    List<SimpleArticleInfoVO> simpleArticleList;

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public List<SimpleArticleInfoVO> getSimpleArticleList() {
        return simpleArticleList;
    }

    public void setSimpleArticleList(List<SimpleArticleInfoVO> simpleArticleList) {
        this.simpleArticleList = simpleArticleList;
    }
}
