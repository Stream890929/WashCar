package com.qfedu.wc.provider.controller;

import com.qfedu.wc.common.vo.R;
import com.qfedu.wc.provider.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Stream
 * @date: 2019/11/07 11:29
 * @version: 1.0
 * @description:
 */
@RestController
public class RecordController {
    @Autowired
    private RecordService recordService;

    @GetMapping(value = "/provider/record/queryAll.do")
    public R queryAll() {
        return recordService.queryAll ();
    }

}
