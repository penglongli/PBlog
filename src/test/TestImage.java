import com.pblog.core.utils.ImageFormatUtils;
import junit.framework.TestCase;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class TestImage extends TestCase{

    public void testWaterMark() throws IOException {
        File file = new File("E:\\pblog\\static\\8c1ba0ed13644803850f06aaaf0f0596.png");

        ImageFormatUtils.waterMark(file);
    }

    //图片缩放
    public void testResizeImage() throws IOException {
        File imageFile = new File("E:\\test\\header.png");
        //缩放后的宽度和高度
        int width = 120, height = 120;

        BufferedImage imageBuffer = ImageIO.read(imageFile);
        BufferedImage tempBuffer = new BufferedImage(width, height, BufferedImage.TYPE_INT_BGR);

        //使用tempBuffer创建一个temp画板
        Graphics graphics = tempBuffer.createGraphics();
        //把原文件画在这个画板上
        graphics.drawImage(imageBuffer, 0, 0, width, height, null);
        imageBuffer.flush();
        tempBuffer.flush();

        String filePath = "E:\\test\\header-120x120.png";
        File temp = new File(filePath);
        temp.createNewFile();
        //把画出来120*120图片的buffer写到temp文件
        ImageIO.write(tempBuffer, "png", temp);
    }

    /**
     * 图片变圆，四个角变透明
     * @throws IOException
     */
    public void testResizeCircle() throws IOException {
        File imageFile = new File("E:\\test\\header-120x120.png");
        BufferedImage imageBuffer = ImageIO.read(imageFile);
        int width = imageBuffer.getWidth(), height = imageBuffer.getHeight();

        BufferedImage tempBuffer = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Ellipse2D.Double shape = new Ellipse2D.Double(0, 0, width, height);

        Graphics2D g2 = tempBuffer.createGraphics();
        tempBuffer = g2.getDeviceConfiguration().createCompatibleImage(width, height, Transparency.TRANSLUCENT);
        g2 = tempBuffer.createGraphics();
        g2.setComposite(AlphaComposite.Clear);
        g2.fill(new Rectangle(width, height));
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC, 1.0f));
        g2.setClip(shape);
        g2.drawImage(imageBuffer, 0, 0, null);
        g2.dispose();


        ImageIO.write(tempBuffer, "png", imageFile);
    }


}
