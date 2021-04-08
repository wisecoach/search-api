package com.watering.controller;

import com.watering.domain.DTO.ResponseDTO;
import com.watering.domain.entity.EmployeeEntity;
import com.watering.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeMapper employeeMapper;

    @RequestMapping("/{id}")
    public ResponseDTO find(@PathVariable("id") Integer id){
        EmployeeEntity employeeEntity = employeeMapper.find(id);
        return ResponseDTO.succData(employeeEntity);
    }

    // "到时候会用pagehelper，老子不会"
    @Deprecated
    @RequestMapping("/list")
    public ResponseDTO findList(){
        List<EmployeeEntity> list = employeeMapper.findList();
        return ResponseDTO.succData(list);
    }
}
