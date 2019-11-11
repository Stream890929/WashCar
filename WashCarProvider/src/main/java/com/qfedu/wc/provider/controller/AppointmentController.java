package com.qfedu.wc.provider.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.qfedu.wc.common.vo.R;
import com.qfedu.wc.entity.Appointment;
import com.qfedu.wc.provider.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Stream
 * @date: 2019/11/06 20:44
 * @version: 1.0
 * @description: 提供者服务，预约
 */
@RestController
public class AppointmentController {
    @Autowired
    private AppointmentService appointmentService;

    /**
     * 添加预约
     * @param appointment 预约实体
     */
    @HystrixCommand(fallbackMethod = "saveFallBack")
    @PostMapping("/provider/appointment/save.do")
    public R save(@RequestBody Appointment appointment){
        // 测试降级方法
        System.out.println (1/0);
        return appointmentService.save(appointment);
    }

    // 降级方法，必须与对应的方法参数、返回值类型一致
    public R saveFallBack(Appointment appointment){
        System.out.println ("服务降级方法触发。");
        return R.fail ("服务繁忙！");
    }

    /**
     * 查询所有预约
     */
    @GetMapping("/provider/appointment/queryAll.do")
    @HystrixCommand
    public R queryAll(){
        return appointmentService.queryAll();
    }

}
