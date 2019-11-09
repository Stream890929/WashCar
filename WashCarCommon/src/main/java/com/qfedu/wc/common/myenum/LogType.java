package com.qfedu.wc.common.myenum;

/**
 * @author: Stream
 * @date: 2019/11/07 11:32
 * @version: 1.0
 * @description: 日志，服务类型
 */
public enum LogType {
    /**
     * 日志类型
     */
    XiChe ("洗车"), DingDan ("订单"), PingJia ("评价");
    private String type;

    private LogType(String t) {
        type = t;
    }

    public String getType() {
        return type;
    }

}
