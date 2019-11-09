package com.qfedu.wc.provider.service;

import com.qfedu.wc.common.vo.R;
import com.qfedu.wc.entity.Order;

public interface OrderService {

    R save(Order order);

    R queryAll();

}
