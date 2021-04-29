package com.watering.service;

import com.watering.domain.DTO.ResponseDTO;
import com.watering.domain.VO.series.OccupationAmountSeriesVO;

public interface ChartService {

    ResponseDTO<OccupationAmountSeriesVO> getOccupationAmount(Integer id, Integer size);
}
