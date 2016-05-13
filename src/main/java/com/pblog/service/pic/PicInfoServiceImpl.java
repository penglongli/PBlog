package com.pblog.service.pic;

import com.pblog.core.utils.MultipartFileValidator;
import com.pblog.dao.PicInfoMapper;
import com.pblog.domain.PicInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service(value = "picInfoService")
@Transactional
public class PicInfoServiceImpl implements PicInfoService{

    private static String staticPath = "E:\\pblog\\static";

    private static String relPath = "/static/image/";

    @Autowired
    private PicInfoMapper picInfoMapper;

    public List<PicInfo> list() {

        return picInfoMapper.selectAll();
    }

    public void upload(MultipartFile file) throws IOException {
        MultipartFileValidator.validate(file);

        String fileName = makeFileName(file);
        File tempFile = new File(staticPath, fileName);

        boolean success = tempFile.createNewFile();
        if (success) {
            file.transferTo(tempFile);

            PicInfo picInfo = new PicInfo();
            picInfo.setCreateTime(new Date());
            picInfo.setPhysicalPath(staticPath + File.separator + fileName);
            picInfo.setRelativePath(relPath + fileName);
            picInfoMapper.insert(picInfo);
        } else {
            throw new RuntimeException("文件上传服务器失败，请刷新后重试！");
        }

    }

    public int deleteById(Long picId) {
        PicInfo picInfo = picInfoMapper.selectById(picId);

        File file = new File(picInfo.getPhysicalPath());
        if(!file.exists()) {
            //文件删除失败，不存在
            return 0;
        } else {
            boolean success = file.delete();
            if(success) {
                return picInfoMapper.deleteByPrimaryKey(picId);
            } else {
                //文件删除失败
                return 0;
            }
        }
    }

    private String getSuffix(MultipartFile file) {
        String fileName = file.getOriginalFilename();
        int n = fileName.indexOf(".");

        return fileName.substring(n);
    }

    private String makeFileName(MultipartFile file) {
        String suffix = getSuffix(file);
        String fileName = UUID.randomUUID().toString().replace("-", "");

        return fileName + suffix;
    }
}
