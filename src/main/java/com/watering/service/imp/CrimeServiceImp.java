package com.watering.service.imp;

import com.watering.dao.CrimeEntityMapper;
import com.watering.dao.ManagerEntityMapper;
import com.watering.domain.DTO.ResponseDTO;
import com.watering.domain.VO.CrimeVO;
import com.watering.domain.entity.CrimeEntity;
import com.watering.domain.entity.ManagerEntity;
import com.watering.service.CrimeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: Parsley
 * @Date: 2021/04/13/17:29
 * @Description:
 */
@Service
public class CrimeServiceImp implements CrimeService {

    @Autowired
    private CrimeEntityMapper crimeEntityMapper;

    @Autowired
    private ManagerEntityMapper managerEntityMapper;

    public ResponseDTO<List<CrimeVO>> findAllCrime(Integer empid) {
        List<CrimeVO> list = new ArrayList<>();
        List<CrimeEntity> crimeEntities = crimeEntityMapper.selectAllByEmpid(empid);
        for (CrimeEntity crimeEntity : crimeEntities) {
            CrimeVO crimeVO = new CrimeVO();
            BeanUtils.copyProperties(crimeEntity, crimeVO);
            crimeVO.setManager(managerEntityMapper.selectByPrimaryKey(crimeEntity.getManid()).getName());
            list.add(crimeVO);
        }
        return ResponseDTO.succData(list);
    }

    public ResponseDTO<List<CrimeVO>> findCurCrime(Integer carid) {
        List<CrimeVO> list = new ArrayList<>();
        List<CrimeEntity> crimeEntities = crimeEntityMapper.selectAllByCarid(carid);
        for (CrimeEntity crimeEntity : crimeEntities) {
            CrimeVO crimeVO = new CrimeVO();
            ManagerEntity managerEntity = managerEntityMapper.selectByPrimaryKey(crimeEntity.getManid());
            BeanUtils.copyProperties(crimeEntity, crimeVO);
            crimeVO.setManager(managerEntity.getName());
            list.add(crimeVO);
        }
        return ResponseDTO.succData(list);
    }


}
