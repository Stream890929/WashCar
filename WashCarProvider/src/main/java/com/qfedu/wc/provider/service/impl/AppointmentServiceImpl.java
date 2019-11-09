package com.qfedu.wc.provider.service.impl;

import com.alibaba.fastjson.JSON;
import com.qfedu.wc.common.config.RabbitMQQueueConfig;
import com.qfedu.wc.common.config.RedisKeyConfig;
import com.qfedu.wc.common.utils.RedissonUtil;
import com.qfedu.wc.common.vo.R;
import com.qfedu.wc.entity.Appointment;
import com.qfedu.wc.provider.dao.AppointmentDao;
import com.qfedu.wc.provider.service.AppointmentService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AppointmentServiceImpl implements AppointmentService {
    @Autowired
    private AppointmentDao appointmentDao;
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public R save(Appointment appointment) {
        if (appointmentDao.save (appointment) != null) {
            // 新增预约信息成功，发送消息
            rabbitTemplate.convertAndSend (RabbitMQQueueConfig.YUYUE_QUEUE, JSON.toJSONString (appointment));
            return R.ok ();
        } else {
            return R.fail ();
        }
    }

    @Override
    public R queryAll() {
        // 1.先从Redis中查找
        if (RedissonUtil.checkKey (RedisKeyConfig.YUYUE_KEY)) {
            // 键-- id，值--json字符串
            Collection<Object> hash = RedissonUtil.getHash (RedisKeyConfig.YUYUE_KEY);
            System.out.println (hash);
            List<Appointment> list = new ArrayList<> (hash.size ());
            for (Object obj : hash) {
                list.add (JSON.parseObject ((String) obj, Appointment.class));
            }
            return R.ok (list);
        } else {
            // 2.查询MySQL
            List<Appointment> list = appointmentDao.findAll ();
            // 3.更新Redis
            Map<Object, String> map = new HashMap<> ();
            for (Appointment appointment : list) {
                map.put (appointment.getId (), JSON.toJSONString (appointment));
            }
            RedissonUtil.putAllHash (RedisKeyConfig.YUYUE_KEY, 24 * 3600, map);
            // 返回结果
            return R.ok (list);
        }
    }

}
