package com.watering.controller;


import com.watering.constant.FileTypeEnum;
import com.watering.domain.DTO.ResponseDTO;
import com.watering.service.FileUploadService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;

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

    @Autowired
    private FileUploadService fileUploadService;

    @ApiOperation("上传简历")
    @PostMapping("/resume")
    public ResponseDTO<String> uploadResume(@RequestBody MultipartFile resume){
        return fileUploadService.uploadFile(resume, FileTypeEnum.IMG_RESUME);
    }

    @ApiOperation("测试用的")
    @GetMapping("/check")
    public ResponseDTO check(@RequestParam String name) throws FileNotFoundException {
        return ResponseDTO.succData(fileUploadService.checkFile(name,FileTypeEnum.IMG_RESUME));
    }

    @ApiOperation("上传头像")
    @PostMapping("/photo")
    public ResponseDTO<String> uploadPhoto(@RequestBody MultipartFile photo){
        return fileUploadService.uploadFile(photo,FileTypeEnum.IMG_PHOTO);
    }

    @ApiOperation("修改头像")
    @PutMapping("/photo")
    public ResponseDTO updatePhoto(@RequestBody MultipartFile photo) throws FileNotFoundException {
        return fileUploadService.updateFile(photo,FileTypeEnum.IMG_PHOTO);
    }


}
