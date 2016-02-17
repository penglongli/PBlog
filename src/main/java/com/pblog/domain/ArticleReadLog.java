package com.pblog.domain;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ArticleReadLog {
    private Long id;

    private Integer articleId;

    private String ipAddress;

    private Date createTime;

    private Integer type;

    public static Map<String, Integer> TYPE = new HashMap<String, Integer>(){
        {
            put("READ", 1);
            put("LIKE", 2);
        }
    };

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress == null ? null : ipAddress.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}