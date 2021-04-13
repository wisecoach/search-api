package com.watering.service.imp;

import com.watering.dao.AttendanceEntityMapper;
import com.watering.dao.ManagerEntityMapper;
import com.watering.domain.DTO.ResponseDTO;
import com.watering.domain.VO.AttendanceVO;
import com.watering.domain.entity.AttendanceEntity;
import com.watering.domain.entity.ManagerEntity;
import com.watering.service.AttendanceService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: Parsley
 * @Date: 2021/04/13/17:32
 * @Description:
 */
@Service
public class AttendanceServiceImp implements AttendanceService {

    @Autowired
    private AttendanceEntityMapper attendanceEntityMapper;

    @Autowired
    private ManagerEntityMapper managerEntityMapper;

    public ResponseDTO<List<AttendanceVO>> findCurAttendance(Integer carid) {
        List<AttendanceVO> list = new ArrayList<>();
        List<AttendanceEntity> attendanceEntities = attendanceEntityMapper.selectAllByCarid(carid);
        for (AttendanceEntity attendanceEntity : attendanceEntities) {
            AttendanceVO attendanceVO = new AttendanceVO();
            ManagerEntity managerEntity = managerEntityMapper.selectByPrimaryKey(attendanceEntity.getManid());
            BeanUtils.copyProperties(attendanceEntity, attendanceVO);
            attendanceVO.setManager(managerEntity.getName());
            list.add(attendanceVO);

        }
        return ResponseDTO.succData(list);
    }

}
