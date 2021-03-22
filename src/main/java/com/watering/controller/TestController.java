package com.watering.controller;

import com.watering.entity.DTO.ResponseDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: Parsley
 * @Date: 2021/03/22/19:27
 * @Description: 测试用
 */
@RestController
public class TestController {

    @GetMapping("/test")
    public ResponseDTO test(){
        return ResponseDTO.succMsg("请求test成功");
    }

}
