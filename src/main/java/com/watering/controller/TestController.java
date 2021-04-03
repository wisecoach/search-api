package com.watering.controller;

import com.watering.domain.DTO.ResponseDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: Parsley
 * @Date: 2021/03/22/19:27
 * @Description: 测试用
 */
@Api(tags = "测试swagger用的类")
@ApiIgnore
@RestController
public class TestController {

    @ApiOperation("测试方法")
    @GetMapping("/test")
    public ResponseDTO test(){
        return ResponseDTO.succMsg("请求test成功");
    }

}
