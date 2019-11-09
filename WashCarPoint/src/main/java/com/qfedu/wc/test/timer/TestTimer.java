package com.qfedu.wc.test.timer;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @author: Stream
 * @date: 2019/11/08 07:51
 * @version: 1.0
 * @description:
 */
public class TestTimer {
    public static void main(String[] args) {
        Timer timer = new Timer ("test01");
        timer.schedule (new TimerTask () {
            @Override
            public void run() {
                System.out.println ("定时器！"+System.currentTimeMillis ()/1000);
            }
        },2000,5000);
    }

}
