import com.pblog.core.utils.DateFormatUtils;
import junit.framework.TestCase;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TestFormat extends TestCase{

    private ClassPathXmlApplicationContext applicationContext;

    protected void setUp(){
        applicationContext = new ClassPathXmlApplicationContext("classpath:application.xml");
    }

    public void testFormatTimeStamp(){
        String t1 = "2016-05";

        try {
            Date date = DateFormatUtils.formatStrToYM(t1);
            System.out.println(date.compareTo(new Date()));
            System.out.println(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public void testAddMonth() throws ParseException {
        /*SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        String str = "2016-03";
        Date date = sdf.parse(str);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, 1);
        date = calendar.getTime();
        System.out.println(date);*/
    }

}
