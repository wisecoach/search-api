package com.watering.service.imp;

import com.github.pagehelper.PageInfo;
import com.watering.constant.FileTypeEnum;
import com.watering.dao.*;
import com.watering.domain.DTO.ResponseDTO;
import com.watering.domain.DTO.career.CareerAddDTO;
import com.watering.domain.DTO.employee.EmployeeAddDTO;
import com.watering.domain.DTO.employee.EmployeeUpdateBaseDTO;
import com.watering.domain.DTO.employee.EmployeeUpdateCareerDTO;
import com.watering.domain.DTO.search.KeyWord;
import com.watering.domain.DTO.search.SearchDTO;
import com.watering.domain.DTO.search.SearchFilter;
import com.watering.domain.VO.CareerVO;
import com.watering.domain.VO.EmployeeSimpleVO;
import com.watering.domain.VO.EmployeeVO;
import com.watering.domain.VO.HrVO;
import com.watering.domain.entity.CareerEntity;
import com.watering.domain.entity.EmployeeEntity;
import com.watering.domain.entity.EnterpriseEntity;
import com.watering.domain.entity.HrEntity;
import com.watering.service.EmployeeService;
import com.watering.service.FileUploadService;
import com.watering.service.OccupationService;
import com.watering.utils.GetCurrentUser;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.FileNotFoundException;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: Parsley
 * @Date: 2021/04/10/15:58
 * @Description:
 */
@Service
public class EmployeeServiceImp implements EmployeeService {

    @Autowired
    private EmployeeEntityMapper employeeEntityMapper;
    @Autowired
    private EnterpriseEntityMapper enterpriseEntityMapper;
    @Autowired
    private DepartmentEntityMapper departmentEntityMapper;
    @Autowired
    private HrEntityMapper hrEntityMapper;
    @Autowired
    private FileUploadService fileUploadService;
    @Autowired
    private CareerEntityMapper careerEntityMapper;
    @Autowired
    private AttendanceEntityMapper attendanceEntityMapper;
    @Autowired
    private PerformanceEntityMapper performanceEntityMapper;
    @Autowired
    private OccupationService occupationService;

    @Override
    public ResponseDTO<EmployeeVO> findEmployeeBasicInfo(Integer empid) {
        EmployeeEntity employeeEntity = employeeEntityMapper.selectByPrimaryKey(empid);
        String enterpriseName = null;
        String departmentName = null;
        HrVO hrVO = null;
        if(employeeEntity.isHired()){
            hrVO = new HrVO();
            enterpriseName = enterpriseEntityMapper.selectByPrimaryKey(employeeEntity.getEntid()).getName();
            departmentName = departmentEntityMapper.selectByPrimaryKey(employeeEntity.getDepid()).getName();
            HrEntity hrEntity =hrEntityMapper.selectByPrimaryKey(employeeEntity.getHrid());
            BeanUtils.copyProperties(hrEntity,hrVO);
            hrVO.setEnterprise(enterpriseName);
        }
        EmployeeVO employeeVO =new EmployeeVO();
        BeanUtils.copyProperties(employeeEntity,employeeVO);
        employeeVO.setEnterprise(enterpriseName);
        employeeVO.setDepartment(departmentName);
        employeeVO.setHr(hrVO);
        return ResponseDTO.succData(employeeVO);
    }

    //修改档案注意图片修改
    @Override
    public ResponseDTO updateEmployeeBasicInfo(EmployeeUpdateBaseDTO employeeUpdateBaseDTO) throws FileNotFoundException {
        EmployeeEntity employeeEntity = employeeEntityMapper.selectByPrimaryKey(employeeUpdateBaseDTO.getId());
        String newPhoto = employeeUpdateBaseDTO.getPhoto();
        String newResume = employeeUpdateBaseDTO.getResume();
        String oldPhoto = employeeEntity.getPhoto();
        String oldResume = employeeEntity.getResume();
        newPhoto = checkImgUrl(newPhoto,oldPhoto,FileTypeEnum.IMG_PHOTO);
        newResume = checkImgUrl(newResume,oldResume,FileTypeEnum.IMG_RESUME);
        BeanUtils.copyProperties(employeeUpdateBaseDTO,employeeEntity);
        employeeEntity.setPhoto(newPhoto);
        employeeEntity.setResume(newResume);
        employeeEntityMapper.updateByPrimaryKey(employeeEntity);
        return ResponseDTO.succMsg("档案更新成功");
    }

    //新增基本信息档案
    @Override
    public ResponseDTO<Integer> addEmployeeBasicInfo(EmployeeAddDTO employeeAddDTO) throws FileNotFoundException {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        String newPhoto = checkImgUrl(employeeAddDTO.getPhoto(),FileTypeEnum.IMG_PHOTO);
        String newResume = checkImgUrl(employeeAddDTO.getResume(),FileTypeEnum.IMG_RESUME);
        BeanUtils.copyProperties(employeeAddDTO,employeeEntity);
        employeeEntity.setPhoto(newPhoto);
        employeeEntity.setResume(newResume);
        employeeEntityMapper.insert(employeeEntity);
        return ResponseDTO.succData(employeeEntity.getId());
    }

    //录入雇员，修改career经历
    //新增career
    @Override
    @Transactional
    public ResponseDTO employ(CareerAddDTO careerAddDTO) {
        HrEntity hrEntity = (HrEntity) GetCurrentUser.getUser();
        EmployeeUpdateCareerDTO employeeUpdateCareerDTO = careerAddDTO.getEmployee();
        EmployeeEntity employeeEntity = employeeEntityMapper.selectByPrimaryKey(employeeUpdateCareerDTO.getEmpid());
        //生成经历
        CareerEntity careerEntity = new CareerEntity();
        careerEntity.setCtime(new Date());
        careerEntity.setDepid(employeeUpdateCareerDTO.getDepid());
        careerEntity.setEmpid(employeeUpdateCareerDTO.getEmpid());
        careerEntity.setEntid(hrEntity.getEntid());
        careerEntity.setOccid(careerAddDTO.getOccid());
        careerEntity.setStime(new Date());
        careerEntityMapper.insert(careerEntity);
        employeeEntity.setDepid(employeeUpdateCareerDTO.getDepid());
        employeeEntity.setEntid(hrEntity.getEntid());
        employeeEntity.setHired(true);
        employeeEntity.setInnid(employeeUpdateCareerDTO.getInnid());
        employeeEntity.setHrid(hrEntity.getId());
        employeeEntityMapper.updateByPrimaryKey(employeeEntity);
        occupationService.addCount(careerAddDTO.getOccid());
        return ResponseDTO.succMsg("录用成功");
    }

    //离职
    //简历中删除career信息
    //计算平均分
    //结束一段经历
    //加工龄
    @Override
    @Transactional
    public ResponseDTO quit(Integer empid) {
        EmployeeEntity employeeEntity = employeeEntityMapper.selectByPrimaryKey(empid);
        CareerEntity careerEntity = careerEntityMapper.selectLastCareerByEmpId(empid);
        careerEntity.setAttendance(attendanceEntityMapper.selectAvgByCarid(careerEntity.getId()));
        careerEntity.setPerformance(performanceEntityMapper.selectAvgByCarid(careerEntity.getId()));
        careerEntity.setEtime(new Date());
        employeeEntity.setHired(false);
        employeeEntity.setDepid(null);
        employeeEntity.setEntid(null);
        employeeEntity.setInnid(null);
        employeeEntity.setHrid(null);
        careerEntityMapper.updateByPrimaryKey(careerEntity);
        employeeEntityMapper.updateByPrimaryKey(employeeEntity);
        return ResponseDTO.succMsg("离职成功");
    }

    //如果关键词是部门，那么就先找到该公司部门的编号
    //过滤器是职业，先找出符合employee
    //必须是本公司的
    @Override
    public ResponseDTO<PageInfo<EmployeeSimpleVO>> innerEmployeeSearch(SearchDTO searchDTO) {
        List<SearchFilter> searchFilters = searchDTO.getFilters();
        KeyWord keyWord = searchDTO.getKey();
        if(keyWord.getType()== KeyWord.Type.DEPARTMENT){
            
        }
        return null;
    }

    @Override
    public ResponseDTO<PageInfo<EmployeeSimpleVO>> dropEmployeeSearch(SearchDTO searchDTO) {
        return null;
    }


    /**
     *
     @param oldImgUrl:原来的图片路径
     @param newImgUrl:新的图片路径
     @param type:图片文件类型
     @return :确定下来的图片路径
     */
    private String checkImgUrl(String newImgUrl,String oldImgUrl,FileTypeEnum type) throws FileNotFoundException {
        if(null!=newImgUrl){
            if(fileUploadService.checkFile(newImgUrl, type))
                newImgUrl = FileTypeEnum.IMG_PHOTO.getUrl() + newImgUrl;
            else
                newImgUrl = oldImgUrl;
        }else{
            newImgUrl = oldImgUrl;
        }
        return newImgUrl;
    }

    private String checkImgUrl(String newImgUrl,FileTypeEnum type) throws FileNotFoundException {
        return checkImgUrl(newImgUrl,null,type);
    }


}
