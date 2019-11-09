package com.qfedu.wc.api.service;

import com.qfedu.wc.common.vo.R;
import com.qfedu.wc.entity.Evaluate;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "WashCarProvider")
public interface EvaluateService {

    @PostMapping(value = "/provider/evaluate/save.do")
    public R save(@RequestBody Evaluate evaluate);

    @GetMapping(value = "/provider/evaluate/queryAll.do")
    public R queryAll(@RequestParam int oid);

}
