package com.watering.service.imp;

import com.watering.dao.ManagerEntityMapper;
import com.watering.dao.PerformanceEntityMapper;
import com.watering.domain.DTO.ResponseDTO;
import com.watering.domain.VO.PerformanceVO;
import com.watering.domain.entity.ManagerEntity;
import com.watering.domain.entity.PerformanceEntity;
import com.watering.service.PerformanceService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: Parsley
 * @Date: 2021/04/13/17:35
 * @Description:
 */
@Service
public class PerformanceServiceImp implements PerformanceService {

    @Autowired
    private PerformanceEntityMapper performanceEntityMapper;

    @Autowired
    private ManagerEntityMapper managerEntityMapper;

    public ResponseDTO<List<PerformanceVO>> findCurPerformance(Integer carid) {
        List<PerformanceVO> list = new ArrayList<>();
        List<PerformanceEntity> performanceEntities = performanceEntityMapper.selectAllByCarid(carid);
        for (PerformanceEntity performanceEntity : performanceEntities) {
            PerformanceVO performanceVO = new PerformanceVO();
            ManagerEntity managerEntity = managerEntityMapper.selectByPrimaryKey(performanceEntity.getManid());
            BeanUtils.copyProperties(performanceEntity, performanceVO);
            performanceVO.setManager(managerEntity.getName());
            list.add(performanceVO);
        }
        return ResponseDTO.succData(list);
    }

}
