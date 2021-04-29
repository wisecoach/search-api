package com.watering.controller;

import com.watering.domain.DTO.ResponseDTO;
import com.watering.domain.VO.series.OccupationAmountSeriesVO;
import com.watering.domain.entity.OccupationEntity;
import com.watering.service.ChartService;
import com.watering.service.OccupationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/chart")
public class ChartController {

    @Autowired
    private ChartService chartService;

    @RequestMapping("/amount")
    public ResponseDTO getAmount(
            @RequestParam("occid") Integer occid,
            @RequestParam(value = "size",defaultValue = "7") Integer size
    ){
        ResponseDTO<OccupationAmountSeriesVO> occupationAmount = chartService.getOccupationAmount(occid, size);
        return occupationAmount;
    }
}
