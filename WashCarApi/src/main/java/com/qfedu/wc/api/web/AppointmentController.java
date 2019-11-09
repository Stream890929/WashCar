package com.qfedu.wc.api.web;

import com.qfedu.wc.api.service.AppointmentService;
import com.qfedu.wc.common.vo.R;
import com.qfedu.wc.entity.Appointment;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Stream
 * @date: 2019/11/06 21:17
 * @version: 1.0
 * @description:
 */
@Api(value = "预约接口", tags = "预约操作")
@RestController
public class AppointmentController {
    @Autowired
    private AppointmentService appointmentService;

    @ApiOperation(value = "新增预约信息",notes = "新增预约信息")
    @PostMapping("/api/appointment/save.do")
    public R save(@RequestBody Appointment appointment){
        return appointmentService.save(appointment);
    }

    @ApiOperation(value = "查看所有的预约信息",notes = "查看所有的预约信息")
    @GetMapping("/api/appointment/queryAll.do")
    public R queryAll(){
        return appointmentService.queryAll();
    }

}
