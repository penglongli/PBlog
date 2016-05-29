package com.pblog.core.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * 图片格式类，暂时把水印位置，水印颜色，水印字体写死。以后如果有时间可以考虑增加前台页面操作。
 */
public class ImageFormatUtils {

    private static Logger logger = LoggerFactory.getLogger(ImageFormatUtils.class);

    private static Font font = new Font(Font.MONOSPACED, Font.BOLD, 16);// 添加字体的属性设置


    /**
     * 为图片增加水印
     * @param uploadFile 图片
     * @return
     */
    public static void waterMark(File uploadFile) throws IOException {
        BufferedImage uploadImage = ImageIO.read(uploadFile);
        int width = uploadImage.getWidth();
        int height = uploadImage.getHeight();

        BufferedImage combined = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics g = combined.getGraphics();
        g.drawImage(uploadImage, 0, 0, null);
        g.setFont(font);
        g.setColor(new Color(216, 216, 210));
        g.drawString("PBlog | www.pelinli.com", 5, height - 24);
        g.drawString("https://github.com/penglongli", 5, height - 10);

        ImageIO.write(combined, "png", uploadFile);
    }

}
