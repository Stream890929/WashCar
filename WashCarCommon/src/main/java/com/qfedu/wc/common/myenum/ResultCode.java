package com.qfedu.wc.common.myenum;

/**
 * @author: Stream
 * @date: 2019/11/06 19:30
 * @version: 1.0
 * @description: 枚举类型 定义统一返回码
 */
public enum ResultCode {
    /**
     * 成功返回200，失败返回400
     */
    SUCCESS (200), FAIL (400);

    private int code;

    private ResultCode(int v) {
        code = v;
    }

    public int getCode() {
        return code;
    }

}
