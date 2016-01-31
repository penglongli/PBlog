package com.pblog.domain;

public class AuthorInfo {

    private int id;

    private String name;

    private String motto;

    private String email;

    private String address;

    private String github;

    private String zhihu;

    private String csdn;

    private String headImage;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMotto() {
        return motto;
    }

    public void setMotto(String motto) {
        this.motto = motto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGithub() {
        return github;
    }

    public void setGithub(String github) {
        this.github = github;
    }

    public String getZhihu() {
        return zhihu;
    }

    public void setZhihu(String zhihu) {
        this.zhihu = zhihu;
    }

    public String getCsdn() {
        return csdn;
    }

    public void setCsdn(String csdn) {
        this.csdn = csdn;
    }

    public String getHeadImage() {
        return headImage;
    }

    public void setHeadImage(String headImage) {
        this.headImage = headImage;
    }
}
