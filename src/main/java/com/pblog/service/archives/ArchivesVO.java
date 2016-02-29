package com.pblog.service.archives;


import com.pblog.service.article.SimpleArticleInfo;

import java.util.List;

public class ArchivesVO {

    private String timeStamp;

    List<SimpleArticleInfo> simpleArticleList;

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public List<SimpleArticleInfo> getSimpleArticleList() {
        return simpleArticleList;
    }

    public void setSimpleArticleList(List<SimpleArticleInfo> simpleArticleList) {
        this.simpleArticleList = simpleArticleList;
    }
}
