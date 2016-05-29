import com.pblog.core.utils.ImageFormatUtils;
import junit.framework.TestCase;

import java.io.File;
import java.io.IOException;

public class TestImage extends TestCase{

    public void testWaterMark() throws IOException {
        File file = new File("E:\\pblog\\static\\8c1ba0ed13644803850f06aaaf0f0596.png");

        ImageFormatUtils.waterMark(file);
    }
}
