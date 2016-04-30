package com.pblog.service.about;

import com.pblog.dao.AboutInfoMapper;
import com.pblog.domain.AboutInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service(value = "aboutService")
@Transactional
public class AboutServiceImpl implements AboutService{

    @Autowired
    private AboutInfoMapper aboutInfoMapper;

    public AboutInfo findAboutInfo() {

        return  aboutInfoMapper.queryByPrimaryKey(1);
    }
}
