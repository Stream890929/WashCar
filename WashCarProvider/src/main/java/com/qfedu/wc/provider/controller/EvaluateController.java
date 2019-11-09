package com.qfedu.wc.provider.controller;

import com.qfedu.wc.common.vo.R;
import com.qfedu.wc.entity.Evaluate;
import com.qfedu.wc.provider.service.EvaluateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author: Stream
 * @date: 2019/11/07 11:28
 * @version: 1.0
 * @description: 提供者，评价
 */
@RestController
public class EvaluateController {
    @Autowired
    private EvaluateService evaluateService;

    /**
     * 新增评价
     *
     * @param evaluate 评价实体
     */
    @PostMapping(value = "/provider/evaluate/save.do")
    public R save(@RequestBody Evaluate evaluate) {
        return evaluateService.save (evaluate);
    }

    /**
     * 查询评价
     *
     * @param oid 订单id
     */
    @GetMapping(value = "/provider/evaluate/queryAll.do")
    public R queryAll(@RequestParam int oid) {
        return evaluateService.queryByOid (oid);
    }

}
