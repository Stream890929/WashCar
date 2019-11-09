package com.qfedu.wc.common.utils;

import org.redisson.Redisson;
import org.redisson.api.RMap;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author: Stream
 * @date: 2019/11/07 19:19
 * @version: 1.0
 * @description: Redisson工具类
 */
public class RedissonUtil {
    private static RedissonClient redissonClient;

    static {
        Config config = new Config ();
        config.useSingleServer ().setAddress ("redis://118.190.132.99:6379").setConnectionPoolSize (64);
        redissonClient = Redisson.create (config);
    }

    /**
     * 新增
     *
     * @param key   键
     * @param value 值
     */
    public static void setString(String key, String value) {
        //1、字符串类型
        redissonClient.getBucket (key).set (value);
//        //2、List
//        client.getList(key).add(value);
//        //3、Set
//        client.getSet(key).add(value);
//        //4、ZSet
//        client.getScoredSortedSet(key).add(2.3,value);
//        //5、Hash
//        client.getMap(key).put("aa",value);
//        Map<Object,Double>  ;  ZSet
    }

    public static void putHash(String key, String field, String value) {
        redissonClient.getMap (key).put (field, value);
    }

    public static void putAllHash(String key, long seconds, Map<Object, String> map) {
        RMap<Object, Object> rMap = redissonClient.getMap (key);
        if (seconds > 0) {
            rMap.expire (seconds, TimeUnit.SECONDS);
        }
        rMap.putAll (map);
    }

    /**
     * 删除
     *
     * @param key 键
     */
    public static void delKey(String key) {
        redissonClient.getKeys ().delete (key);
    }

    /**
     * 查询
     *
     * @param key 键
     */
    public static String getStr(String key) {
        return (String) redissonClient.getBucket (key).get ();
    }

    public static Collection<Object> getHash(String key) {
        return redissonClient.getMap (key).values ();
    }



    /**
     * 设置有效期
     *
     * @param key     键
     * @param seconds 时间/秒
     */
    public static void setExpire(String key, long seconds) {
        redissonClient.getKeys ().expire (key, seconds, TimeUnit.SECONDS);
    }

    /**
     * 开启分布式锁
     *
     * @param key 键
     */
    public static void lock(String key) {
        redissonClient.getLock (key).lock ();
    }

    /**
     * 释放分布式锁
     *
     * @param key 键
     */
    public static void unlock(String key) {
        redissonClient.getLock (key).unlock ();
    }

    /**
     * 验证key释放存在
     *
     * @param key 键
     * @return
     */
    public static boolean checkKey(String key) {
        return redissonClient.getKeys ().countExists (key) > 0;
    }

}
