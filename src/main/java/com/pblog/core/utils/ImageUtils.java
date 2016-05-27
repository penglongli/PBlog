package com.pblog.core.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Component
public class ImageUtils {

    private static Logger logger = LoggerFactory.getLogger(ImageUtils.class);

    public static String staticPath = "/var/static/pblog/image/";

    public static String relPath = "/static/image/";

    public static String uploadImage(MultipartFile file) throws IOException {
        String fileName = makeFileName(file);
        File tempFile = new File(staticPath, fileName);

        boolean success = tempFile.createNewFile();
        if (success) {
            file.transferTo(tempFile);
        } else {
            logger.info("File upload server failure!");
            throw new RuntimeException("文件上传服务器失败");
        }

        return fileName;
    }

    private static String getSuffix(MultipartFile file) {
        String fileName = file.getOriginalFilename();
        int n = fileName.indexOf(".");

        return fileName.substring(n);
    }

    private static String makeFileName(MultipartFile file) {
        String suffix = getSuffix(file);
        String fileName = UUID.randomUUID().toString().replace("-", "");

        return fileName + suffix;
    }
}
