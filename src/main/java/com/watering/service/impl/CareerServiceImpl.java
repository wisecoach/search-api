package com.watering.service.impl;

import com.watering.dao.*;
import com.watering.domain.DTO.ResponseDTO;
import com.watering.domain.VO.CareerVO;
import com.watering.domain.entity.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Service
public class CareerServiceImpl {
    @Autowired
    private CareerEntityMapper careerEntityMapper;

    @Autowired
    private EnterpriseEntityMapper enterpriseEntityMapper;

    @Autowired
    private DepartmentEntityMapper departmentEntityMapper;

    @Autowired
    private OccupationEntityMapper occupationEntityMapper;


    public ResponseDTO<List<CareerVO>> findAllCareer(Integer empid) {
        CareerVO careerVO = new CareerVO();
        List<CareerEntity> careerEntities = careerEntityMapper.selectAllByEmpid(empid);
        ArrayList<CareerVO> list = new ArrayList<>();
        for (CareerEntity careerEntity : careerEntities) {
            BeanUtils.copyProperties(careerEntity, careerVO);
            EnterpriseEntity enterpriseEntity = enterpriseEntityMapper.selectByPrimaryKey(careerEntity.getEntid());
            DepartmentEntity departmentEntity = departmentEntityMapper.selectByPrimaryKey(careerEntity.getDepid());
            OccupationEntity occupationEntity = occupationEntityMapper.selectByPrimaryKey(careerEntity.getOccid());
            careerVO.setEnterprise(enterpriseEntity.getName());
            careerVO.setDepartment(departmentEntity.getName());
            careerVO.setOccupation(occupationEntity.getName());
            list.add(careerVO);
        }
        return ResponseDTO.succData(list);
    }
}
