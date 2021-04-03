package com.watering.controller;

import com.watering.domain.DTO.ResponseDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: Parsley
 * @Date: 2021/04/02/19:32
 * @Description:
 */
@Api(tags = "上传")
@RestController
@RequestMapping("/upload")
public class UploadController {

    @ApiOperation("上传简历")
    @PostMapping("/resume")
    public ResponseDTO<String> uploadResume(@RequestBody byte[] resume){
        return null;
    }

    @ApiOperation("上传头像")
    @PostMapping("/photo")
    public ResponseDTO<String> uploadPhoto(@RequestBody byte[] photo){
        return null;
    }

    @ApiOperation("修改头像")
    @PutMapping("/photo")
    public ResponseDTO updatePhoto(@RequestBody byte[] photo){
        return null;
    }


}
