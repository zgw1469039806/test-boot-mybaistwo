package com.gd.test.Utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;

/**
 * @DATA 2019-01-04 15:13
 * @Author zhangguowei  WeChat:17630376104
 * @Description TODO
 * redis工具类
 */

@Component
public class RedisUtils {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    //设置key-value到redis中
    public boolean set(String key, String value)
    {
        try {
            stringRedisTemplate.opsForValue().set(key, value);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    //通过key获取redis里面的值
    public String get(String key)
    {
        return stringRedisTemplate.opsForValue().get(key);
    }
}
