package com.watering.controller;

import com.watering.domain.DTO.ResponseDTO;
import com.watering.domain.entity.OccupationEntity;
import com.watering.service.OccupationService;
import org.apache.ibatis.annotations.Param;
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
    private OccupationService occupationService;

    @RequestMapping("/amount")
    public ResponseDTO getAmount(
            @RequestParam("occid") Integer oocid,
            @RequestParam(value = "size",defaultValue = "7") Integer size
            ){
        Random random = new Random();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add(random.nextInt(100));
        }
        OccupationEntity occupationEntity = occupationService.find(oocid);
        HashMap<Object, Object> map = new HashMap<>();
        map.put("occupation", occupationEntity);
        map.put("series", list);
        return ResponseDTO.succData(map);
    }
}
