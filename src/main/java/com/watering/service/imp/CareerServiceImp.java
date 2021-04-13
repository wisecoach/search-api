package com.watering.service.imp;

import com.watering.dao.CareerEntityMapper;
import com.watering.dao.DepartmentEntityMapper;
import com.watering.dao.EnterpriseEntityMapper;
import com.watering.dao.OccupationEntityMapper;
import com.watering.domain.DTO.ResponseDTO;
import com.watering.domain.VO.CareerVO;
import com.watering.domain.entity.CareerEntity;
import com.watering.service.CareerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: Parsley
 * @Date: 2021/04/11/16:49
 * @Description:
 */
@Service
public class CareerServiceImp implements CareerService {

    @Autowired
    private CareerEntityMapper careerEntityMapper;

    @Autowired
    private OccupationEntityMapper occupationEntityMapper;

    @Autowired
    private DepartmentEntityMapper departmentEntityMapper;

    @Autowired
    private EnterpriseEntityMapper enterpriseEntityMapper;


    @Override
    public ResponseDTO<CareerVO> findCareer(Integer carid) {
        CareerEntity careerEntity = careerEntityMapper.selectByPrimaryKey(carid);
        CareerVO careerVO = new CareerVO();
        BeanUtils.copyProperties(careerEntity,careerVO);
        careerVO.setOccupation(occupationEntityMapper.selectByPrimaryKey(careerEntity.getOccid()).getName());
        careerVO.setDepartment(departmentEntityMapper.selectByPrimaryKey(careerEntity.getDepid()).getName());
        careerVO.setEnterprise(enterpriseEntityMapper.selectByPrimaryKey(careerEntity.getEntid()).getName());
        return ResponseDTO.succData(careerVO);
    }
}
