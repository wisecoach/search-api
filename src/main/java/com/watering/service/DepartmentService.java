package com.watering.service;

import com.watering.domain.DTO.ResponseDTO;
import com.watering.domain.entity.DepartmentEntity;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: Parsley
 * @Date: 2021/04/13/17:40
 * @Description:
 */
public interface DepartmentService {

    public ResponseDTO<List<DepartmentEntity>> departmentSearch();

}
