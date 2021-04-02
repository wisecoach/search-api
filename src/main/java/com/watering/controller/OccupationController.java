package com.watering.controller;

import com.watering.domain.DTO.ResponseDTO;
import com.watering.domain.VO.OccupationVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: Parsley
 * @Date: 2021/04/02/16:46
 * @Description:
 */
@Api(tags = "职业处理")
@RestController
@RequestMapping("/occupation")
public class OccupationController {
    @ApiOperation("根据父id查询子职业")
    @GetMapping("/{occid}")
    public ResponseDTO<List<OccupationVO>> find(@RequestParam Integer occid){
        return null;
    }

    @ApiOperation("热门职业")
    @GetMapping("/hot")
    public ResponseDTO<List<OccupationVO>> hot(){
        return null;
    }

}
