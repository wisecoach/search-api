package com.watering.service.imp;

import com.watering.dao.*;
import com.watering.domain.DTO.ResponseDTO;
import com.watering.domain.DTO.attendance.AttendanceAddDTO;
import com.watering.domain.DTO.crime.CrimeAddDTO;
import com.watering.domain.DTO.performance.PerformanceAddDTO;
import com.watering.domain.VO.*;
import com.watering.domain.entity.*;
import com.watering.service.CareerService;
import com.watering.utils.GetCurrentUser;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    @Autowired
    private ScoreEntityMapper scoreEntityMapper;

    @Autowired
    private EmployeeEntityMapper employeeEntityMapper;

    @Autowired
    private AttendanceEntityMapper attendanceEntityMapper;

    @Autowired
    private CrimeEntityMapper crimeEntityMapper;

    @Autowired
    private ManagerEntityMapper managerEntityMapper;

    @Autowired
    private PerformanceEntityMapper performanceEntityMapper;

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

    public ResponseDTO<List<CareerVO>> findAllCareer(Integer empid) {
        List<CareerEntity> careerEntities = careerEntityMapper.selectAllByEmpid(empid);
        ArrayList<CareerVO> list = new ArrayList<>();
        for (CareerEntity careerEntity : careerEntities) {
            CareerVO careerVO = new CareerVO();
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

    public ResponseDTO<AvgScoreVO> findAvgScore(Integer empid) {
        float attitude = 0, ability = 0;
        AvgScoreVO avgScoreVO = new AvgScoreVO();
        List<CareerEntity> careerEntities = careerEntityMapper.selectAllByEmpid(empid);
        for (CareerEntity careerEntity : careerEntities) {
            attitude += careerEntity.getAttendance();
            ability += careerEntity.getPerformance();
        }
        avgScoreVO.setAttitude(attitude / careerEntities.size());
        avgScoreVO.setAbility(ability / careerEntities.size());
        return ResponseDTO.succData(avgScoreVO);
    }

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

    public ResponseDTO<AvgScoreVO> findCurAvgScore(Integer carid){
        AvgScoreVO avgScoreVO = new AvgScoreVO();
        ScoreEntity scoreEntity = scoreEntityMapper.selectByCarid(carid);
        avgScoreVO.setAttitude(scoreEntity.getAttitude());
        avgScoreVO.setAbility(scoreEntity.getAbility());
        return ResponseDTO.succData(avgScoreVO);
    }

    public ResponseDTO performanceInput(PerformanceAddDTO performance){
        PerformanceEntity performanceEntity = new PerformanceEntity();
        EmployeeEntity employeeEntity = employeeEntityMapper.selectByPrimaryKey(performance.getEmpid());
        CareerEntity careerEntity = careerEntityMapper.selectLastCareerByEmpId(performance.getEmpid());
        ManagerEntity managerEntity = (ManagerEntity) GetCurrentUser.getUser();
        if(employeeEntity.getDepid()==managerEntity.getDepid())
        {
            performanceEntity.setCtime(new Date());
            performanceEntity.setEmpid(performance.getEmpid());
            performanceEntity.setManid(managerEntity.getId());
            performanceEntity.setPerformance(performance.getPerformance());
            performanceEntity.setStime(performance.getStime());
            performanceEntity.setEtime(performance.getEtime());
            if(careerEntity.getDepid()==employeeEntity.getDepid())
            {
                performanceEntity.setCarid(careerEntity.getId());
            }
            else performanceEntity.setCarid(careerEntity.getId()+1);
            performanceEntityMapper.insert(performanceEntity);
            return ResponseDTO.succ();
        }
        else return ResponseDTO.succMsg("您没有权限进行此操作1");
    }

    public ResponseDTO attendanceInput(AttendanceAddDTO attendance){
        AttendanceEntity attendanceEntity = new AttendanceEntity();
        EmployeeEntity employeeEntity = employeeEntityMapper.selectByPrimaryKey(attendance.getEmpid());
        CareerEntity careerEntity = careerEntityMapper.selectLastCareerByEmpId(attendance.getEmpid());
        ManagerEntity managerEntity = (ManagerEntity) GetCurrentUser.getUser();
        if(employeeEntity.getDepid()==managerEntity.getDepid())
        {
            attendanceEntity.setCtime(new Date());
            attendanceEntity.setEmpid(attendance.getEmpid());
            attendanceEntity.setManid(managerEntity.getId());
            attendanceEntity.setAttendance(attendance.getAttendance());
            attendanceEntity.setStime(attendance.getStime());
            attendanceEntity.setEtime(attendance.getEtime());
            if(careerEntity.getDepid()==employeeEntity.getDepid())
            {
                attendanceEntity.setCarid(careerEntity.getId());
            }
            else attendanceEntity.setCarid(careerEntity.getId()+1);
            attendanceEntityMapper.insert(attendanceEntity);
            return ResponseDTO.succ();
        }
        else return ResponseDTO.succMsg("您没有权限进行此操作1");
    }
    public ResponseDTO crimeInput(CrimeAddDTO crime){
        CrimeEntity crimeEntity = new CrimeEntity();
        EmployeeEntity employeeEntity = employeeEntityMapper.selectByPrimaryKey(crime.getEmpid());
        CareerEntity careerEntity = careerEntityMapper.selectLastCareerByEmpId(crime.getEmpid());
        ManagerEntity managerEntity =(ManagerEntity) GetCurrentUser.getUser();
        if(employeeEntity.getDepid()==managerEntity.getDepid()){
            crimeEntity.setCtime(new Date());
            crimeEntity.setEmpid(crime.getEmpid());
            crimeEntity.setManid(managerEntity.getId());
            crimeEntity.setDetail(crime.getDetail());
            crimeEntity.setRank(crime.getRank());
            crimeEntity.setCritime(crime.getCritime());
            if(careerEntity.getDepid()==employeeEntity.getDepid())
            {
                crimeEntity.setCarid(careerEntity.getId());
            }
            else crimeEntity.setCarid(careerEntity.getId()+1);
            crimeEntityMapper.insert(crimeEntity);
            return ResponseDTO.succ();
        }
        else return ResponseDTO.succMsg("您没有权限进行此操作1");
    }
}
