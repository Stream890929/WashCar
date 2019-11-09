package com.qfedu.wc.api.web;

import com.qfedu.wc.api.service.OrderService;
import com.qfedu.wc.common.vo.R;
import com.qfedu.wc.entity.Order;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Stream
 * @date: 2019/11/07 11:41
 * @version: 1.0
 * @description:
 */
@Api(value = "订单相关操作", tags = "订单相关操作")
@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;

    @ApiOperation(value = "新增订单信息", notes = "新增订单信息")
    @PostMapping(value = "/api/order/save.do")
    public R save(@RequestBody Order order) {
        return orderService.save (order);
    }

    @ApiOperation(value = "查询所有订单信息", notes = "查询所有订单信息")
    @GetMapping(value = "/api/order/queryAll.do")
    public R queryAll() {
        return orderService.queryAll ();
    }

}
