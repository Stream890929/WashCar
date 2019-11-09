package com.qfedu.wc.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @author: Stream
 * @date: 2019/11/06 19:23
 * @version: 1.0
 * @description: 记录表
 */
@Data
@Entity
@Table(name = "record")
public class Record {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer oid;
    @Column(length = 35)
    private String type;
    private String info;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date ctime;

    public Record() {
    }

}
