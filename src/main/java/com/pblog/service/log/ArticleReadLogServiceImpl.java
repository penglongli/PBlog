package com.pblog.service.log;

import com.pblog.dao.ArticleReadLogMapper;
import com.pblog.domain.ArticleReadLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service(value = "articleReadLogService")
@Transactional
public class ArticleReadLogServiceImpl implements ArticleReadLogService{

    @Autowired
    private ArticleReadLogMapper articleReadLogMapper;

    public void addByRead(Long articleSlug, String ipAddress) {
        ArticleReadLog articleReadLog = new ArticleReadLog();
        articleReadLog.setCreateTime(new Date());
        articleReadLog.setIpAddress(ipAddress);
        articleReadLog.setArticleSlug(articleSlug);
        articleReadLog.setType(ArticleReadLog.ArticleReadType.TYPE_READ.getId());

        articleReadLogMapper.insert(articleReadLog);
    }
}
