package com.qfedu.wc.provider.service.impl;

import com.qfedu.wc.common.myenum.LogType;
import com.qfedu.wc.common.vo.R;
import com.qfedu.wc.entity.Evaluate;
import com.qfedu.wc.provider.dao.EvaluateDao;
import com.qfedu.wc.provider.service.EvaluateService;
import com.qfedu.wc.provider.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EvaluateServiceImpl implements EvaluateService {
    @Autowired
    private EvaluateDao evaluateDao;
    @Autowired
    private RecordService recordService;

    @Override
    public R save(Evaluate evaluate) {
        try {
            evaluateDao.save (evaluate);
            recordService.saveLog (evaluate.getId (), LogType.PingJia.getType (), "评价");
            return R.setR (true, "OK");
        } catch (Exception e) {
            return R.fail ();
        }
    }

    @Override
    public R queryByOid(int oid) {
        return R.ok (evaluateDao.getByOid (oid));
    }

}
