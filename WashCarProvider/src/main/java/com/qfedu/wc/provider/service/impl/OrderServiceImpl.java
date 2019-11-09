package com.qfedu.wc.provider.service.impl;

import com.qfedu.wc.common.vo.R;
import com.qfedu.wc.entity.Order;
import com.qfedu.wc.provider.dao.OrderDao;
import com.qfedu.wc.provider.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;

    @Override
    public R save(Order order) {
        return R.setR (orderDao.save (order) != null,"OK!");
    }

    @Override
    public R queryAll() {
        return R.ok (orderDao.findAll ());
    }

}
