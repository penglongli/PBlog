package com.pblog.domain;

public class AuthorInfo {
    private Integer id;

    private String name;

    private String motto;

    private String email;

    private String address;

    private String github;

    private String zhihu;

    private String csdn;

    private String headImage;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getMotto() {
        return motto;
    }

    public void setMotto(String motto) {
        this.motto = motto == null ? null : motto.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getGithub() {
        return github;
    }

    public void setGithub(String github) {
        this.github = github == null ? null : github.trim();
    }

    public String getZhihu() {
        return zhihu;
    }

    public void setZhihu(String zhihu) {
        this.zhihu = zhihu == null ? null : zhihu.trim();
    }

    public String getCsdn() {
        return csdn;
    }

    public void setCsdn(String csdn) {
        this.csdn = csdn == null ? null : csdn.trim();
    }

    public String getHeadImage() {
        return headImage;
    }

    public void setHeadImage(String headImage) {
        this.headImage = headImage == null ? null : headImage.trim();
    }
}