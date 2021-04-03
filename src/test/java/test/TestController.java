package test;

import com.watering.ApiMain8081;
import com.watering.dao.*;
import com.watering.domain.DTO.search.KeyWord;
import com.watering.domain.entity.AttendanceEntity;
import com.watering.domain.entity.ManagerEntity;
import com.watering.domain.VO.ManagerVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
        ManagerEntity managerEntity = new ManagerEntity(1,new Date(),"old","1234",1,1,"test","/url");
        ManagerVO managerVO =new ManagerVO(2,new Date(),null,null,null,null,null);
        BeanUtils.copyProperties(managerEntity,managerVO);
        System.out.println(managerVO);
    }



}
