import com.pblog.core.utils.ImageFormatUtils;
import junit.framework.TestCase;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class TestImage extends TestCase{

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

    //合并两个图片(也可以合并多个)
    public void testMerge() throws IOException {
        File newFile = new File("E:\\test\\merge.jpg");
        File backgroundFile = new File("E:\\test\\background.jpg");
        File headerFile = new File("E:\\test\\header-120x120.png");
        BufferedImage backgroundImage = ImageIO.read(backgroundFile); //背景图片
        BufferedImage headerImage = ImageIO.read(headerFile); //头像图片
        int bWidth = backgroundImage.getWidth(), bHeight = backgroundImage.getHeight();
        int hWidth = headerImage.getWidth(), hHeight = headerImage.getHeight();

        BufferedImage combined = new BufferedImage(bWidth, bHeight, BufferedImage.TYPE_INT_RGB);
        Graphics g = combined.getGraphics();
        //先把背景图画到画板上
        g.drawImage(backgroundImage, 0, 0, null);

        //计算出头像放置的 Y 轴位置
        Double tempHeight1 = backgroundImage.getHeight() * 0.2;
        Long tempHeight2 = Math.round(tempHeight1);
        Integer headerImageY = Integer.valueOf(tempHeight2.toString());
        g.drawImage(headerImage, (bWidth - hWidth) / 2, headerImageY, null);

        newFile.createNewFile();
        ImageIO.write(combined, "jpg", newFile);
    }

    //图片加水印
    public void testWaterMark() throws IOException {
        File uploadFile = new File("E:\\test\\background.jpg");
        Font font = new Font(Font.MONOSPACED, Font.BOLD, 20);// 添加字体的属性设置

        BufferedImage uploadImage = ImageIO.read(uploadFile);
        int width = uploadImage.getWidth();
        int height = uploadImage.getHeight();

        BufferedImage combined = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics g = combined.getGraphics();
        g.drawImage(uploadImage, 0, 0, null);
        g.setFont(font);
        g.setColor(Color.RED);
        g.drawString("PBlog | www.pelinli.com", 10, 20);
        g.drawString("https://github.com/penglongli", 10, 40);

        ImageIO.write(combined, "png", uploadFile);
    }


}
