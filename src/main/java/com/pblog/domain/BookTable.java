package com.pblog.domain;

public class BookTable {
    private Integer id;

    private String bookName;

    private String bookUrl;

    private String bookBanner;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName == null ? null : bookName.trim();
    }

    public String getBookUrl() {
        return bookUrl;
    }

    public void setBookUrl(String bookUrl) {
        this.bookUrl = bookUrl == null ? null : bookUrl.trim();
    }

    public String getBookBanner() {
        return bookBanner;
    }

    public void setBookBanner(String bookBanner) {
        this.bookBanner = bookBanner == null ? null : bookBanner.trim();
    }
}