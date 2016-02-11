package com.pblog.domain;

import java.util.Date;

public class ArticleInfo {
    private Integer id;

    private String title;

    private String content;

    private Long slug;

    private Date createTime;

    private Date lastModifyTime;

    private Long categorySlug;

    private String tagId;

    private Integer thumb;

    private Byte enabled;

    private String markdown;

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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastModifyTime() {
        return lastModifyTime;
    }

    public void setLastModifyTime(Date lastModifyTime) {
        this.lastModifyTime = lastModifyTime;
    }

    public Long getCategorySlug() {
        return categorySlug;
    }

    public void setCategorySlug(Long categorySlug) {
        this.categorySlug = categorySlug;
    }

    public String getTagId() {
        return tagId;
    }

    public void setTagId(String tagId) {
        this.tagId = tagId == null ? null : tagId.trim();
    }

    public Integer getThumb() {
        return thumb;
    }

    public void setThumb(Integer thumb) {
        this.thumb = thumb;
    }

    public Byte getEnabled() {
        return enabled;
    }

    public void setEnabled(Byte enabled) {
        this.enabled = enabled;
    }

    public String getMarkdown() {
        return markdown;
    }

    public void setMarkdown(String markdown) {
        this.markdown = markdown == null ? null : markdown.trim();
    }
}