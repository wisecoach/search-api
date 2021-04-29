package com.watering.scheduler;

import com.watering.dao.OccupationEntityMapper;
import com.watering.domain.entity.OccupationEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import static com.watering.constant.RedisCacheKeyConst.*;

/**
 * @author: wisecoach
 * @data: 2021/4/29 下午2:04
 * @version: 1.0.0
 */
@Component
public class ChartScheduler {
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private OccupationEntityMapper occupationMapper;

    @Scheduled(cron = "0 0 4 * * ?")
    public void countOccuaptionAmountDaily() {
        Integer today = (Integer) redisTemplate.opsForValue().get(MONTH_COUNT_TODAY);
        System.out.println(today);
        if (today == null) {
            today = 0;
        }
        redisTemplate.opsForValue().set(MONTH_COUNT_TODAY, ++today);
        for (OccupationEntity occupationEntity : occupationMapper.selectAll()) {
            redisTemplate.opsForValue().set(
                    MONTH_COUNT_PREF + ":" + today + ":" + occupationEntity.getId(),
                    occupationEntity.getCount());
        }
    }
}
