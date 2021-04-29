package com.watering.cache.keygenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import static com.watering.constant.RedisCacheKeyConst.*;

import java.lang.reflect.Method;

@Component
public class MonthKeyGenerator implements KeyGenerator {
    @Qualifier("redisTemplate")
    @Autowired
    private RedisTemplate template;

    @Override
    public Object generate(Object target, Method method, Object... params) {
        Integer today = (Integer) template.opsForValue().get(MONTH_COUNT_TODAY);
        return MONTH_COUNT_PREF + ":" + params[1] + ":" + params[0];
    }
}
