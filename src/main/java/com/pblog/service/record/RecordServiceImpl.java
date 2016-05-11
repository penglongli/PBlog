package com.pblog.service.record;

import com.google.common.collect.Lists;
import com.pblog.dao.RecordInfoMapper;
import com.pblog.domain.RecordInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service(value = "recordService")
@Transactional
public class RecordServiceImpl implements RecordService{

    @Autowired
    private RecordInfoMapper recordInfoMapper;

    public List<RecordInfo> list() {
        List<RecordInfo> recordInfoList = Lists.newArrayList();

        recordInfoList = recordInfoMapper.selectAll();
        for(RecordInfo recordInfo : recordInfoList) {
            recordInfo.setId(null);
        }

        return recordInfoList;
    }
}
