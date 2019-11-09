package com.qfedu.wc.provider.dao;

import com.qfedu.wc.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderDao extends JpaRepository<Order,Integer> {

    List<Order> getByTime(String time);

}
