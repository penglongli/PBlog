package com.pblog.junit;

import com.pblog.service.ManageArticleInfoService;
import junit.framework.TestCase;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestFuck extends TestCase {
    private ClassPathXmlApplicationContext applicationContext;

    protected void setUp(){
        applicationContext = new ClassPathXmlApplicationContext("classpath:application.xml");
    }

    public void testOne(){
        Long categorySlug = null;
        ManageArticleInfoService manageArticleInfoService = (ManageArticleInfoService) applicationContext.getBean("manageArticleInfoService");
        manageArticleInfoService.findListByCategorySlug(categorySlug);


       /* ArticleInfoService articleInfoService = (ArticleInfoService) applicationContext.getBean("articleInfoService");

        ArticleInfo articleInfo = new ArticleInfo();

        int a = articleInfoService.insert(articleInfo);

        System.out.println(a);
        System.out.println(articleInfo.getId());*/
    }
}
