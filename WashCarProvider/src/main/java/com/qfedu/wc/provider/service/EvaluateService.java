package com.qfedu.wc.provider.service;

import com.qfedu.wc.common.vo.R;
import com.qfedu.wc.entity.Evaluate;

public interface EvaluateService {

    R save(Evaluate evaluate);

    R queryByOid(int oid);

}
