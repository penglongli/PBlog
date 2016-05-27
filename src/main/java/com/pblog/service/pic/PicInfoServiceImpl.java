package com.pblog.service.pic;

import com.pblog.core.utils.ImageUtils;
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

@Service(value = "picInfoService")
@Transactional
public class PicInfoServiceImpl implements PicInfoService{

    @Autowired
    private PicInfoMapper picInfoMapper;

    public List<PicInfo> list() {

        return picInfoMapper.selectAll();
    }

    public void upload(MultipartFile file) throws IOException {
        MultipartFileValidator.validate(file);
        String fileName = ImageUtils.uploadImage(file);

        PicInfo picInfo = new PicInfo();
        picInfo.setCreateTime(new Date());
        picInfo.setPhysicalPath(ImageUtils.staticPath + File.separator + fileName);
        picInfo.setRelativePath(ImageUtils.relPath + fileName);
        picInfoMapper.insert(picInfo);
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


}
