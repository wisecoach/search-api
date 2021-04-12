package com.watering.controller;

import com.watering.domain.DTO.ResponseDTO;
import com.watering.domain.VO.EmployeeVO;
import com.watering.domain.entity.EmployeeEntity;
import com.watering.dao.EmployeeEntityMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/info")
public class InfoController {
    @Autowired
    private EmployeeEntityMapper employeeMapper;

    @RequestMapping("/employee/{empid}")
    public ResponseDTO<EmployeeVO> searchEmployee(@PathVariable("empid") Integer empid){
        EmployeeEntity employeeEntity = employeeMapper.selectByPrimaryKey(empid);
        EmployeeVO employeeVO = new EmployeeVO();
        BeanUtils.copyProperties(employeeEntity, employeeVO);
        return ResponseDTO.succData(employeeVO);
    }
}
