package com.watering.service;

import com.watering.domain.DTO.ResponseDTO;
import com.watering.domain.VO.CareerVO;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: Parsley
 * @Date: 2021/04/11/16:49
 * @Description:
 */
public interface CareerService {

    public ResponseDTO<CareerVO> findCareer(Integer carid);
    public ResponseDTO<List<CareerVO>> findAllCareer(Integer empid);

}
