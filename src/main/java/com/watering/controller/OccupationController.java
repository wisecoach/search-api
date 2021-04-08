package com.watering.controller;

import com.watering.domain.DTO.ResponseDTO;
import com.watering.domain.entity.OccupationEntity;
import com.watering.service.OccupationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/occupation")
public class OccupationController {
    @Autowired
    private OccupationService occupationService;

    @RequestMapping("/{pid}")
    public ResponseDTO findChildren(@PathVariable("pid") Integer pid){
        List<OccupationEntity> children = occupationService.findChildren(pid);
        return ResponseDTO.succData(children);
    }
}
