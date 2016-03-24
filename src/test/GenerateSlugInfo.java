import com.pblog.service.slug.SlugInfoService;
import junit.framework.TestCase;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class GenerateSlugInfo extends TestCase{
    private ClassPathXmlApplicationContext applicationContext;

    protected void setUp(){
        applicationContext = new ClassPathXmlApplicationContext("classpath:application.xml");
    }

    public void testInsertSlug(){
        SlugInfoService slugInfoService = (SlugInfoService) applicationContext.getBean("slugInfoService");
        System.out.println(slugInfoService);
        slugInfoService.insert();
    }

}
