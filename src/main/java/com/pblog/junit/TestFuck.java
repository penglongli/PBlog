package com.pblog.junit;

import com.pblog.domain.ArticleInfo;
import com.pblog.service.ArticleInfoService;
import junit.framework.TestCase;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestFuck extends TestCase {
    private ClassPathXmlApplicationContext applicationContext;

    protected void setUp(){
        applicationContext = new ClassPathXmlApplicationContext("classpath:application.xml");
    }

    public void testOne(){
        ArticleInfoService articleInfoService = (ArticleInfoService) applicationContext.getBean("articleInfoService");

        ArticleInfo articleInfo = new ArticleInfo();

        articleInfoService.insert(articleInfo);
    }
}
