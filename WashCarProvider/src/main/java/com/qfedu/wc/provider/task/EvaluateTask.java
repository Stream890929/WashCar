package com.qfedu.wc.provider.task;

import com.qfedu.wc.common.utils.DateUtil;
import com.qfedu.wc.entity.Evaluate;
import com.qfedu.wc.entity.Order;
import com.qfedu.wc.provider.dao.EvaluateDao;
import com.qfedu.wc.provider.dao.OrderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Stream
 * @date: 2019/11/07 20:55
 * @version: 1.0
 * @description: 定时任务，检查未评价订单
 */
@Component
public class EvaluateTask {
    @Autowired
    private EvaluateDao evaluateDao;
    @Autowired
    private OrderDao orderDao;

    /**
     * 7天默认好评，每天执行一次
     */
    @Scheduled(cron = "0 0 0 * * ?")
    public void defaultPingjia() {
        String time = DateUtil.getTime (-7);
        // 查询7天前为评价的订单
        List<Order> orderList = orderDao.getByTime (time);
        List<Evaluate> evaluates = new ArrayList<> (orderList.size ());
        for (Order order : orderList) {
            Evaluate evaluate = new Evaluate ();
            evaluate.setComment ("默认好评");
            evaluate.setOid (order.getId ());
            evaluate.setScore (100);
            evaluate.setType ("好评！");
            evaluates.add (evaluate);
        }
        evaluateDao.saveAll (evaluates);
    }

}
