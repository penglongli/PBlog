package com.pblog.service.archives;


import com.pblog.service.article.SimpleArticleInfoVO;

import java.util.List;
import java.util.Map;

public class ArchivesVO {

    private String timeStamp;

    List<Map<String, SimpleArticleInfoVO>> articleMap;

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public List<Map<String, SimpleArticleInfoVO>> getArticleMap() {
        return articleMap;
    }

    public void setArticleMap(List<Map<String, SimpleArticleInfoVO>> articleMap) {
        this.articleMap = articleMap;
    }
}
