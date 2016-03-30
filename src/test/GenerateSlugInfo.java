import com.google.common.collect.Lists;
import com.pblog.service.archives.ArchivesVO;
import com.pblog.service.article.SimpleArticleInfo;
import com.pblog.service.slug.SlugInfoService;
import junit.framework.TestCase;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class GenerateSlugInfo extends TestCase{
    private ClassPathXmlApplicationContext applicationContext;

    protected void setUp(){
        applicationContext = new ClassPathXmlApplicationContext("classpath:application.xml");
    }

    public void testInsertSlug(){
        SlugInfoService slugInfoService = (SlugInfoService) applicationContext.getBean("slugInfoService");
        slugInfoService.insert();
    }

    public void testArray(){
        /*List<ArchivesVO> archivesVOList = Lists.newArrayList();

        ArchivesVO archivesVO = new ArchivesVO();
        archivesVO.setTimeStamp("2016-03");

        List<SimpleArticleInfo> simpleArticleInfoList = Lists.newArrayList();
        archivesVO.setSimpleArticleList(simpleArticleInfoList);

        SimpleArticleInfo simpleArticleInfo = new SimpleArticleInfo();
        simpleArticleInfoList.add(simpleArticleInfo);
        archivesVOList.add(archivesVO);*/



        int a = 1;
    }

    public void testDate() throws ParseException {
       /* SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        String dateStr = "2016-03";

        Date date = sdf.parse(dateStr);
        System.out.println(date);*/
    }

}
