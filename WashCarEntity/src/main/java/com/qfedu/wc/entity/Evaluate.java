package com.qfedu.wc.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @author: Stream
 * @date: 2019/11/06 19:18
 * @version: 1.0
 * @description: 评论实体
 */
@Data
@Entity
@Table(name = "evaluate")
public class Evaluate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "order_id")
    private Integer oid;
    @Column(length = 30)
    private String type;
    private Integer score;
    private String comment;

    public Evaluate() {
    }

}
