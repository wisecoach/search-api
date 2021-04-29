package com.watering.domain.VO.series;

import com.watering.domain.entity.OccupationEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author: wisecoach
 * @data: 2021/4/29 上午1:31
 * @version: 1.0.0
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class OccupationAmountSeriesVO {
    private OccupationEntity occupation;
    private Integer size;
    private List<Integer> series;
}
