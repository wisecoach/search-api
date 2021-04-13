package com.watering.service.imp;

import com.watering.dao.DepartmentEntityMapper;
import com.watering.domain.DTO.ResponseDTO;
import com.watering.domain.entity.DepartmentEntity;
import com.watering.domain.entity.EnterpriseEntity;
import com.watering.service.DepartmentService;
import com.watering.utils.GetCurrentUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: Parsley
 * @Date: 2021/04/13/17:40
 * @Description:
 */
@Service
public class DepartmentServiceImp implements DepartmentService {

    @Autowired
    private DepartmentEntityMapper departmentEntityMapper;

    public ResponseDTO<List<DepartmentEntity>> departmentSearch(){
        EnterpriseEntity enterpriseEntity = (EnterpriseEntity) GetCurrentUser.getUser();
        List<DepartmentEntity> list = departmentEntityMapper.listByEntid(enterpriseEntity.getId());
        return ResponseDTO.succData(list);
    }

}
