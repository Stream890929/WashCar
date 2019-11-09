package com.qfedu.wc.api.ribbon.impl;

import com.qfedu.wc.api.ribbon.RecordService;
import com.qfedu.wc.common.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author: Stream
 * @date: 2019/11/08 22:00
 * @version: 1.0
 * @description:
 */
@Service
public class RecordServiceImpl implements RecordService {
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public R queryAll() {
        //Get请求
//        restTemplate.getForObject("路径","结果的Class对象")
        //Post请求
//        restTemplate.postForObject();
        //Put请求
//        restTemplate.put();
        //Delete请求
//        restTemplate.delete();

        return restTemplate.getForObject ("http://WashCarProvider/provider/record/queryAll.do", R.class);
    }

}
