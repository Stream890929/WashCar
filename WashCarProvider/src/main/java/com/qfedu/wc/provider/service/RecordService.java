package com.qfedu.wc.provider.service;

import com.qfedu.wc.common.vo.R;
import com.qfedu.wc.entity.Record;

public interface RecordService {

    void save(Record record);

    R queryAll();

    void saveLog(int oid, String type, String info);

}
