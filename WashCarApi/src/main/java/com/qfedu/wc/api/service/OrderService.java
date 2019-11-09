package com.qfedu.wc.api.service;

import com.qfedu.wc.common.vo.R;
import com.qfedu.wc.entity.Order;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "WashCarProvider")
public interface OrderService {

    @PostMapping(value = "/provider/order/save.do")
    public R save(@RequestBody Order order);

    @GetMapping(value = "/provider/order/queryAll.do")
    public R queryAll();

}
