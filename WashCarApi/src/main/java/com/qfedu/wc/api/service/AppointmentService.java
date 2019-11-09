package com.qfedu.wc.api.service;

import com.qfedu.wc.common.vo.R;
import com.qfedu.wc.entity.Appointment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "WashCarProvider")
public interface AppointmentService {

    @PostMapping("/provider/appointment/save.do")
    R save(@RequestBody Appointment appointment);

    @GetMapping("/provider/appointment/queryAll.do")
    R queryAll();

}
