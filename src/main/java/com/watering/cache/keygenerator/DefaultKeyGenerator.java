package com.watering.cache.keygenerator;

import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Component
public class DefaultKeyGenerator implements KeyGenerator {
    @Override
    public Object generate(Object target, Method method, Object... params) {
        StringBuffer buffer = new StringBuffer();
        String className = method.getDeclaringClass().getName();
        String methodName = method.getName();
        buffer.append(className).append(":").append(methodName);
        for (Object param : params) {
            buffer.append(":" + param);
        }
        return buffer;
    }
}
