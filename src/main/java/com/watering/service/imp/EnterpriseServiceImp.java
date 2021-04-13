package com.watering.service.imp;

import com.watering.dao.IndustryEntityMapper;
import com.watering.domain.DTO.ResponseDTO;
import com.watering.domain.VO.EnterpriseVO;
import com.watering.domain.entity.EnterpriseEntity;
import com.watering.service.EnterpriseService;
import com.watering.utils.GetCurrentUser;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: Parsley
 * @Date: 2021/04/10/18:04
 * @Description:
 */
@Service
public class EnterpriseServiceImp implements EnterpriseService {

    @Autowired
    private IndustryEntityMapper industryEntityMapper;

    @Override
    public ResponseDTO<EnterpriseVO> getInfo() {
        EnterpriseVO enterpriseVO =new EnterpriseVO();
        EnterpriseEntity enterpriseEntity = (EnterpriseEntity) GetCurrentUser.getUser();
        BeanUtils.copyProperties(enterpriseEntity,enterpriseVO);
        enterpriseVO.setIndustry(industryEntityMapper.selectByPrimaryKey(enterpriseEntity.getIndid()).getName());
        return ResponseDTO.succData(enterpriseVO);
    }
}
