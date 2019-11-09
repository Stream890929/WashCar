package com.qfedu.wc.provider.service.impl;

import com.qfedu.wc.common.vo.R;
import com.qfedu.wc.entity.Record;
import com.qfedu.wc.provider.dao.RecordDao;
import com.qfedu.wc.provider.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class RecordServiceImpl implements RecordService {
    @Autowired
    private RecordDao recordDao;

    @Override
    public void save(Record record) {
        recordDao.save (record);
    }

    @Override
    public R queryAll() {
        return R.ok (recordDao.findAll ());
    }

    @Override
    public void saveLog(int oid, String type, String info) {
        Record record = new Record ();
        record.setCtime (new Date ());
        record.setInfo (info);
        record.setOid (oid);
        record.setType (type);
        save (record);
    }

}
