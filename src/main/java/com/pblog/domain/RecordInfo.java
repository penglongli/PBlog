package com.pblog.domain;

import java.util.Date;

public class RecordInfo {
    private Integer id;

    private String title;

    private Date createTime;

    private String content;

    private Long slug;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Long getSlug() {
        return slug;
    }

    public void setSlug(Long slug) {
        this.slug = slug;
    }
}