package com.watering.service.imp;

import com.watering.dao.OccupationEntityMapper;
import com.watering.domain.DTO.ResponseDTO;
import com.watering.domain.VO.OccupationVO;
import com.watering.domain.entity.OccupationEntity;
import com.watering.service.OccupationService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: Parsley
 * @Date: 2021/04/11/17:44
 * @Description:
 */
@Service
public class OccupationServiceImp implements OccupationService {

    private OccupationEntityMapper occupationEntityMapper;

    @Override
    public void addCount(Integer occid) {
        OccupationEntity occupationEntity = occupationEntityMapper.selectByPrimaryKey(occid);
        Integer pid = occupationEntity.getPid();
        while(pid!=-1){
            occupationEntity.setCount(occupationEntity.getCount()+1);
            occupationEntityMapper.updateByPrimaryKey(occupationEntity);
            occupationEntity = occupationEntityMapper.selectByPrimaryKey(pid);
            pid = occupationEntity.getPid();
        }
    }

    @Override
    public void subtractCount(Integer occid) {
        OccupationEntity occupationEntity = occupationEntityMapper.selectByPrimaryKey(occid);
        Integer pid = occupationEntity.getPid();
        while(pid!=-1){
            occupationEntity.setCount(occupationEntity.getCount()-1);
            occupationEntityMapper.updateByPrimaryKey(occupationEntity);
            occupationEntity = occupationEntityMapper.selectByPrimaryKey(pid);
            pid = occupationEntity.getPid();
        }
    }

    @Override
    public ResponseDTO<List<OccupationEntity>> listSonOccupation(Integer occid) {
        List<OccupationEntity> occupationEntities = occupationEntityMapper.listSonById(occid);
        return ResponseDTO.succData(occupationEntities);
    }

    @Override
    public ResponseDTO<List<OccupationEntity>> hotOccupation() {
        List<OccupationEntity> occupationEntities = occupationEntityMapper.listHot();
        return ResponseDTO.succData(occupationEntities);
    }
}
