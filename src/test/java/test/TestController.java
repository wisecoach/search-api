package test;

import com.watering.ApiMain8081;
import com.watering.dao.*;
import com.watering.domain.DTO.ResponseDTO;
import com.watering.domain.DTO.search.KeyWord;
import com.watering.domain.VO.CareerVO;
import com.watering.domain.entity.*;
import com.watering.domain.VO.ManagerVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.util.ResourceUtils;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: Parsley
 * @Date: 2021/03/24/17:19
 * @Description:
 */
@SpringBootTest(classes = ApiMain8081.class)
public class TestController {

    @Autowired
    private AttendanceEntityMapper mapper;
    @Autowired
    private CareerEntityMapper careerEntityMapper;
    @Autowired
    private CrimeEntityMapper crimeEntityMapper;
    @Autowired
    private DepartmentEntityMapper departmentEntityMapper;
    @Autowired
    private EmployeeEntityMapper employeeEntityMapper;
    @Autowired
    private EnterpriseEntityMapper enterpriseEntityMapper;
    @Autowired
    private HrEntityMapper hrEntityMapper;
    @Autowired
    private IndustryEntityMapper industryEntityMapper;
    @Autowired
    private ManagerEntityMapper managerEntityMapper;
    @Autowired
    private OccupationEntityMapper occupationEntityMapper;
    @Autowired
    private PerformanceEntityMapper performanceEntityMapper;
    @Autowired
    private ScoreEntityMapper scoreEntityMapper;

    @Test
    public void test(){
        List lists = new ArrayList();
        lists.add(mapper.selectAll());
        lists.add(careerEntityMapper.selectAll());
        lists.add(crimeEntityMapper.selectAll());
        lists.add(departmentEntityMapper.selectAll());
        lists.add(employeeEntityMapper.selectAll());
        lists.add(enterpriseEntityMapper.selectAll());
        lists.add(hrEntityMapper.selectAll());
        lists.add(industryEntityMapper.selectAll());
        lists.add(managerEntityMapper.selectAll());
        lists.add(occupationEntityMapper.selectAll());
        lists.add(performanceEntityMapper.selectAll());
        lists.add(scoreEntityMapper.selectAll());
        System.out.println(lists);
    }
    @Test
    public void test1(){
        ManagerEntity managerEntity = new ManagerEntity(null);
        ManagerVO managerVO =new ManagerVO(2,new Date(),null,null,null,null,null);
        BeanUtils.copyProperties(managerEntity,managerVO);
        System.out.println(managerVO);
    }

    @Test
    public void test2(){
        System.out.println(UUID.randomUUID().toString().replace("-",""));
        System.out.println( "apk.java".substring("apk.java".lastIndexOf(".")));
        System.out.println( "apk.java".substring(0,"apk.java".lastIndexOf(".")));
    }

    @Test
    public void test3(){
        HrEntity hrEntity = hrEntityMapper.selectByPrimaryKey(1);
        System.out.println(hrEntity);
//        ManagerEntity managerEntity = managerEntityMapper.selectByPrimaryKey(1);
//        System.out.println(managerEntity);
    }

    @Test
    public void test4(){
        System.out.println(new BCryptPasswordEncoder().encode("zhaojing"));
        System.out.println(new BCryptPasswordEncoder().encode("xhjy"));
        System.out.println(new BCryptPasswordEncoder().encode("zhuzhen"));
        System.out.println(new BCryptPasswordEncoder().encode("zhangdudu"));
    }

    @Test
    public void findAllCareer() {
        CareerVO careerVO = new CareerVO();
        List<CareerEntity> careerEntities = careerEntityMapper.selectAllByEmpid(1);
        List<CareerVO> list = new ArrayList<>();
        for (CareerEntity careerEntity : careerEntities) {
            BeanUtils.copyProperties(careerEntity, careerVO);
            EnterpriseEntity enterpriseEntity = enterpriseEntityMapper.selectByPrimaryKey(careerEntity.getEntid());
            DepartmentEntity departmentEntity = departmentEntityMapper.selectByPrimaryKey(careerEntity.getDepid());
            OccupationEntity occupationEntity = occupationEntityMapper.selectByPrimaryKey(careerEntity.getOccid());
            careerVO.setEnterprise(enterpriseEntity.getName());
            careerVO.setDepartment(departmentEntity.getName());
            careerVO.setOccupation(occupationEntity.getName());
            list.add(careerVO);
        }
        System.out.println(list);
    }

}
