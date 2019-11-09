package com.qfedu.wc.api.web;

import com.qfedu.wc.api.ribbon.RecordService;
import com.qfedu.wc.common.vo.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Stream
 * @date: 2019/11/07 11:43
 * @version: 1.0
 * @description:
 */
@Api(value = "日志相关操作", tags = "日志相关操作")
@RestController
public class RecordController {
    @Autowired
    private RecordService recordService;

    @ApiOperation(value = "查询所有日志信息", notes = "查询所有日志信息")
    @GetMapping(value = "/api/record/queryAll.do")
    public R queryAll() {
        return recordService.queryAll ();
    }

}
