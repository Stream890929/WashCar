package com.qfedu.wc.api.web;

import com.qfedu.wc.api.service.EvaluateService;
import com.qfedu.wc.common.vo.R;
import com.qfedu.wc.entity.Evaluate;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author: Stream
 * @date: 2019/11/07 11:43
 * @version: 1.0
 * @description:
 */
@Api(value = "评价操作", tags = "评价操作")
@RestController
public class EvaluateController {
    @Autowired
    private EvaluateService evaluateService;

    @ApiOperation(value = "新增评价信息", notes = "新增评价信息")
    @PostMapping(value = "/api/evaluate/save.do")
    public R save(@RequestBody Evaluate evaluate) {
        return evaluateService.save (evaluate);
    }

    @ApiOperation(value = "查询订单的所有评价信息", notes = "查询订单的所有评价信息")
    @GetMapping(value = "/api/evaluate/queryAll.do")
    public R queryAll(@RequestParam int oid) {
        return evaluateService.queryAll (oid);
    }

}
