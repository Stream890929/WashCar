package com.qfedu.wc.common.exception;

/**
 * @author: Stream
 * @date: 2019/11/06 19:28
 * @version: 1.0
 * @description: 自定义异常
 */
public class WashCarException extends Exception {
    public WashCarException() {
        super ("洗洗车出现异常");
    }

    public WashCarException(String msg) {
        super (msg);
    }

}
