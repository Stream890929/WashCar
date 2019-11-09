package com.qfedu.wc.provider.service;

import com.qfedu.wc.common.vo.R;
import com.qfedu.wc.entity.Appointment;

public interface AppointmentService {

    R save(Appointment appointment);

    R queryAll();

}
