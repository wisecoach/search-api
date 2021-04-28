package test.dao;

import com.watering.ApiMain8081;
import io.swagger.annotations.Api;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest(classes = {ApiMain8081.class})
public class RestTest {
    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void test(){
        redisTemplate.opsForValue().set(111, "433");
        System.out.println(redisTemplate.opsForValue().get(111));
    }
}
