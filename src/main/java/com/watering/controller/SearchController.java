package com.watering.controller;

import com.watering.domain.DTO.ResponseDTO;
import com.watering.domain.entity.DepartmentEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;

@RestController
@RequestMapping("/search")
public class SearchController {
    @RequestMapping("department")
    public ResponseDTO searchAllDepartment(){
        ArrayList<DepartmentEntity> entities = new ArrayList<>();
        entities.add(new DepartmentEntity(1, new Date(), "人事部", 1));
        entities.add(new DepartmentEntity(2, new Date(), "研发部", 1));
        entities.add(new DepartmentEntity(3, new Date(), "公关部", 1));
        entities.add(new DepartmentEntity(4, new Date(), "市场部", 1));
        return ResponseDTO.succData(entities);
    }
}
