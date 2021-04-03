package com.watering.controller;

import com.watering.domain.DTO.hr.HrAddDTO;
import com.watering.domain.DTO.hr.HrUpdateDTO;
import com.watering.domain.DTO.ResponseDTO;
import com.watering.domain.DTO.manager.ManagerAddDTO;
import com.watering.domain.DTO.manager.ManagerUpdateDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.ehcache.impl.internal.classes.commonslang.ArrayUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: Parsley
 * @Date: 2021/04/01/15:41
 * @Description: 处理用户账号
 */
@Api(tags = "处理用户账号(修改,创建)")
@RestController
@RequestMapping("/user")
public class UserController {

    @ApiOperation("用sessionId获取用户信息")
    @GetMapping("/myInfo")
    public ResponseDTO WhoAmI(){
        return ResponseDTO.succData(SecurityContextHolder.getContext());
    }

    @ApiOperation("获取验证码")
    @GetMapping("/code")
    public ResponseDTO<byte []> getCode(){
        return ResponseDTO.succData((byte[]) ArrayUtils.toPrimitive(new ArrayList<>()));
    }

    @ApiOperation("创建Hr账号")
    @PostMapping("/hr")
    public ResponseDTO createHr(@RequestBody HrAddDTO hr){
        return ResponseDTO.succMsg("创建Hr成功");
    }

    @ApiOperation("修改Hr账号")
    @PutMapping("/hr")
    public ResponseDTO updateHr(@RequestBody HrUpdateDTO hr){
        return ResponseDTO.succMsg("修改Hr密码成功");
    }

    @ApiOperation("创建主管账号")
    @PostMapping("/manager")
    public ResponseDTO createManager(@RequestBody ManagerAddDTO manager){
        return ResponseDTO.succMsg("创建主管成功");
    }

    @ApiOperation("修改主管账号")
    @PutMapping("/manager")
    public ResponseDTO updateManager(@RequestBody ManagerUpdateDTO manager){
        return ResponseDTO.succMsg("修改主管密码成功");
    }

}
