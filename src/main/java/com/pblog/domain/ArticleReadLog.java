package com.pblog.domain;

import java.util.Date;

public class ArticleReadLog {
    private Long id;

    private Long articleSlug;

    private String ipAddress;

    private Date createTime;

    private Integer type;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getArticleSlug() {
        return articleSlug;
    }

    public void setArticleSlug(Long articleSlug) {
        this.articleSlug = articleSlug;
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

    public enum ArticleReadType {
        TYPE_READ(1),

        TYPE_LIKE(2),

        TYPE_THUMB(3);

        private Integer id;

        ArticleReadType(Integer id){
            this.id = id;
        }

        public Integer getId(){
            return id;
        }
    }
}