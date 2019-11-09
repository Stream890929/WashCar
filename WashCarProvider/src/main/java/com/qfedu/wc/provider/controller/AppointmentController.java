package com.qfedu.wc.provider.controller;

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
    @PostMapping("/provider/appointment/save.do")
    public R save(@RequestBody Appointment appointment){
        return appointmentService.save(appointment);
    }

    /**
     * 查询所有预约
     */
    @GetMapping("/provider/appointment/queryAll.do")
    public R queryAll(){
        return appointmentService.queryAll();
    }

}
