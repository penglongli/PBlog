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

    public void testMinusDate() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String str = "2016-03-03 21:00:00";
        String str1 = "2016-03-03 22:00:00";

        Date date = sdf.parse(str);
        Date date1 = sdf.parse(str1);
        System.out.println(date.getTime());
        System.out.println(date1.getTime());

        Long temp = 3600000L;
        Long num = date1.getTime() - date.getTime();
        System.out.println(num / temp);
    }

}
