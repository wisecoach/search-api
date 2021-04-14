package com.watering.controller;

import com.watering.domain.DTO.ResponseDTO;
import com.watering.domain.DTO.department.DepartmentDTO;
import com.watering.domain.DTO.department.DepartmentUpdateDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: Parsley
 * @Date: 2021/04/02/16:46
 * @Description:
 */
@Api(tags = "部门处理")
@RestController
@RequestMapping("/department")
public class DepartmentController {

    @ApiOperation("新增部门")
    @PostMapping("")
    public ResponseDTO addDepartment(@RequestBody DepartmentDTO department){
        return ResponseDTO.succ();
    }

    @ApiOperation("修改部门")
    @PutMapping("")
    public ResponseDTO updateDepartment(@RequestBody DepartmentUpdateDTO department){
        return ResponseDTO.succ();
    }

}
