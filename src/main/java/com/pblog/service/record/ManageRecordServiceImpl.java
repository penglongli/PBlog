package com.pblog.service.record;

import com.pblog.dao.RecordInfoMapper;
import com.pblog.domain.RecordInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service(value = "manageRecordService")
@Transactional
public class ManageRecordServiceImpl implements ManageRecordService{

    @Autowired
    private RecordInfoMapper recordInfoMapper;

    public int insert(RecordInfo recordInfo) {
        recordInfo.setCreateTime(new Date());

        return recordInfoMapper.insert(recordInfo);
    }

    public List<RecordInfo> list() {

        return recordInfoMapper.selectAll();
    }

    public RecordInfo findById(Integer id) {
        RecordInfo recordInfo = recordInfoMapper.selectById(id);

        return recordInfo;
    }

    public int update(RecordInfo recordInfo) {
        if(recordInfo.getId() == null) {
            throw new RuntimeException("RecordInfo'S id cannot be null when update");
        }

        RecordInfo temp = recordInfoMapper.selectById(recordInfo.getId());
        temp.setTitle(recordInfo.getTitle());
        temp.setContent(recordInfo.getContent());

        return recordInfoMapper.updateByPrimaryKey(temp);
    }

    public int delete(Integer id) {

        return recordInfoMapper.deleteByPrimaryKey(id);
    }
}

