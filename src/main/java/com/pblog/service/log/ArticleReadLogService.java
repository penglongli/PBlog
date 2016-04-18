package com.pblog.service.log;

public interface ArticleReadLogService {

    void addByRead(Long articleSlug, String ipAddress);
}
