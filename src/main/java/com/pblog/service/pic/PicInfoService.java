package com.pblog.service.pic;


import com.pblog.domain.PicInfo;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface PicInfoService {

    void upload(MultipartFile file) throws IOException;

    List<PicInfo> list();

    int deleteById(Long picId);
}
