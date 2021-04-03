package com.watering.controller;

import com.watering.domain.DTO.ResponseDTO;
import com.watering.domain.DTO.employee.EmployeeAddDTO;
import com.watering.domain.DTO.employee.EmployeeUpdateBaseDTO;
import com.watering.domain.VO.EmployeeVO;
import com.watering.domain.VO.EnterpriseVO;
import com.watering.domain.VO.HrVO;
import com.watering.domain.VO.ManagerVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: Parsley
 * @Date: 2021/04/01/16:33
 * @Description:
 */
@Api(tags = "处理基本信息")
@RestController
@RequestMapping("/info")
public class BasicInfoController {

    @ApiOperation("根据员工id查找员工基本信息")
    @GetMapping("/employee/{empid}")
    public ResponseDTO<EmployeeVO> findEmployeeBasicInfo(@RequestParam Integer empid){
        System.out.println(empid);
        return ResponseDTO.succData(new EmployeeVO());
    }

    @ApiOperation("修改employee的基本信息")
    @PutMapping("/employee")
    public ResponseDTO updateEmployeeBasicInfo(@RequestBody EmployeeUpdateBaseDTO employee){
        return ResponseDTO.succ();
    }

    @ApiOperation("新建employee档案")
    @PostMapping("/employee")
    public ResponseDTO addEmployeeBasicInfo(@RequestBody EmployeeAddDTO employee){
        return ResponseDTO.succData(new Integer(1));
    }

    @ApiOperation("公司账号登录查询公司基本信息")
    @GetMapping("/enterprise")
    public ResponseDTO<EnterpriseVO> findEnterpriseBasicInfo(){
        return ResponseDTO.succData(new EnterpriseVO());
    }

    @ApiOperation("Hr账号登录查询Hr基本信息")
    @GetMapping("/hr")
    public ResponseDTO<HrVO> findHrBasicInfo(){
        return ResponseDTO.succData(new HrVO());
    }

    @ApiOperation("主管账号登录查询主管基本信息")
    @GetMapping("/manager")
    public ResponseDTO<ManagerVO> findManagerBasicInfo(){
        return ResponseDTO.succData(new ManagerVO());
    }

}
