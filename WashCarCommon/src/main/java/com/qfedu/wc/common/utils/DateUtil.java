package com.qfedu.wc.common.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * @author: Stream
 * @date: 2019/11/07 19:20
 * @version: 1.0
 * @description: 时间工具类
 */
public class DateUtil {
    /**
     * 获取指定天数
     *
     * @param days 天数
     */
    public static String getTime(int days) {
        Calendar calendar = Calendar.getInstance ();
        calendar.add (Calendar.DAY_OF_MONTH, days);
        return new SimpleDateFormat ("yyyy-MM-dd").format (calendar.getTime ());
    }

}
