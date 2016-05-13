package com.pblog.core.utils;


import org.apache.commons.lang.ArrayUtils;
import org.springframework.web.multipart.MultipartFile;

public class MultipartFileValidator {

    private final static long MAX_SIZE = 5 * 1024 * 1024;

    //文件上传上限
    private static long maxSize = MAX_SIZE;

    //可接受的content-type
    private static String[] allowedContentTypes = {"image/jpeg", "image/jpg", "image/png", "image/gif"};

    public static void validate(MultipartFile file) throws RuntimeException {

        if (!ArrayUtils.contains(allowedContentTypes, file.getContentType())) {
            throw new RuntimeException("The content type is not a valid content type!");
        }

        if(file.getSize() > maxSize) {
            throw new RuntimeException("The file uploaded is out of max file size!");
        }
    }

}
