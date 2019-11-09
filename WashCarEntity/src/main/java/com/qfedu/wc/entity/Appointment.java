package com.qfedu.wc.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @author: Stream
 * @date: 2019/11/06 19:15
 * @version: 1.0
 * @description: 预约实体
 */
@Data
@Entity //标记这是映射类 这个类对应有表
@Table(name = "appointment") //设置表名
public class Appointment {
    @Id //标记这是主键
    @GeneratedValue(strategy = GenerationType.IDENTITY)//标记主键的生成策略  自增 Mysql
    private Integer id;
    @Column(length = 30)
    private String type;
    private String shop_name;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date appointment_time;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date arrival_time;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date create_time;
    private String appointment_code;
    private String car_owner_name;
    private String contact_type;
    private String car_licence;

    public Appointment() {
    }

}
