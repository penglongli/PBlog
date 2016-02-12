package com.pblog.service;

import com.pblog.dao.ArticleInfoMapper;
import com.pblog.domain.ArticleInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service("articleInfoService")
@Transactional
public class ArticleInfoServiceImpl implements ArticleInfoService{

    @Resource
    private ArticleInfoMapper articleInfoMapper;

    public int insert(ArticleInfo articleInfo) {
       return articleInfoMapper.insert(articleInfo);
    }
}
