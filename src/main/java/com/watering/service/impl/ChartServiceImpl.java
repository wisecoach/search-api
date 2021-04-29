package com.watering.service.impl;

import com.watering.dao.OccupationEntityMapper;
import com.watering.domain.DTO.ResponseDTO;
import com.watering.domain.VO.series.OccupationAmountSeriesVO;
import com.watering.domain.entity.OccupationEntity;
import com.watering.service.ChartService;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import static com.watering.constant.RedisCacheKeyConst.*;

/**
 * @author: wisecoach
 * @data: 2021/4/29 上午1:33
 * @version: 1.0.0
 */
@Service
public class ChartServiceImpl implements ChartService {
    @Qualifier("redisTemplate")
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private OccupationEntityMapper occupationEntityMapper;

    @Override
    public ResponseDTO<OccupationAmountSeriesVO> getOccupationAmount(Integer id, Integer size) {
        OccupationAmountSeriesVO seriesVO = new OccupationAmountSeriesVO();
        OccupationEntity occupationEntity = occupationEntityMapper.selectByPrimaryKey(id);
        seriesVO.setOccupation(occupationEntity);
        seriesVO.setSize(size);
        Integer today = (Integer) redisTemplate.opsForValue().get(MONTH_COUNT_TODAY);
        if (today == null) {
            today = 0;
            redisTemplate.opsForValue().set(MONTH_COUNT_TODAY, today);
        }
        ArrayList<Integer> series = new ArrayList<>();
        for (int i = 0, d = today-size < 0 ? today + 30 : today; i < size; i++) {
            d = (++d >=30) ? d-30:d;
            Integer data = occupationEntityMapper.selectCountByPrimaryKeyForCache(id, d);
            series.add(data);
        }
        seriesVO.setSeries(series);
        return ResponseDTO.succData(seriesVO);
    }
}
