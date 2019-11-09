package com.qfedu.wc.provider.controller;

import com.qfedu.wc.common.vo.R;
import com.qfedu.wc.entity.Order;
import com.qfedu.wc.provider.service.OrderService;
import com.qfedu.wc.provider.service.impl.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Stream
 * @date: 2019/11/07 11:28
 * @version: 1.0
 * @description:
 */
@RestController
public class OrderController {
    @Autowired
    private OrderServiceImpl orderService;

    /**
     * 新增订单
     *
     * @param order 订单实体
     */
    @PostMapping(value = "/provider/order/save.do")
    public R save(@RequestBody Order order) {
        return orderService.save (order);
    }

    /**
     * 查询所有订单信息
     */
    @GetMapping(value = "/provider/order/queryAll.do")
    public R queryAll() {
        return orderService.queryAll ();
    }

}
