package com.qfedu.wc.provider.dao;

import com.qfedu.wc.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentDao extends JpaRepository<Appointment,Integer> {
}
