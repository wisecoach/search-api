package com.watering.controller;

import com.github.pagehelper.PageInfo;
import com.watering.domain.DTO.ResponseDTO;
import com.watering.domain.DTO.attendance.AttendanceAddDTO;
import com.watering.domain.DTO.career.CareerAddDTO;
import com.watering.domain.DTO.crime.CrimeAddDTO;
import com.watering.domain.DTO.performance.PerformanceAddDTO;
import com.watering.domain.DTO.score.ScoreAddDTO;
import com.watering.domain.VO.*;
import com.watering.service.impl.CareerServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: Parsley
 * @Date: 2021/04/01/17:42
 * @Description:
 */
@Api(tags = "处理工作经历")
@RestController
@RequestMapping("/career")
public class CareerController {

    @Autowired
    private CareerServiceImpl careerService;

    @ApiOperation("根据empid查询员工所有经历")
    @GetMapping("/{empid}")
    public ResponseDTO<List<CareerVO>> findAllCareer(@RequestParam Integer empid){
        return careerService.findAllCareer(empid);
    }

    @ApiOperation("根据empid查询员工全部经历的两项平均分")
    @GetMapping("/avgscore/{empid}")
    public ResponseDTO<AvgScoreVO> findAvgScore(@RequestParam Integer empid){
        return careerService.findAvgScore(empid);
    }

    @ApiOperation("根据empid查询全部的违纪记录")
    @GetMapping("/crime/{empid}")
    public ResponseDTO<List<CrimeVO>> findAllCrime(@RequestParam Integer empid){
        return careerService.findAllCrime(empid);
    }

    @ApiOperation("根据carid查询该经历考勤记录")
    @GetMapping("/attendance/{carid}")
    public ResponseDTO<List<AttendanceVO>> findCurAttendance(@RequestParam Integer carid){
        return careerService.findCurAttendance(carid);
    }

    @ApiOperation("根据carid查询该经历绩效记录")
    @GetMapping("/performance/{carid}")
    public ResponseDTO<List<PerformanceVO>> findCurPerformance(@RequestParam Integer carid){
        return careerService.findCurPerformance(carid);
    }

    @ApiOperation("根据carid查询该经历违纪记录")
    @GetMapping("/curcrime/{carid}")
    public ResponseDTO<List<CrimeVO>> findCurCrime(@RequestParam Integer carid){
        return ResponseDTO.succData(new ArrayList<CrimeVO>());
    }

    @ApiOperation("根据carid,page,pageSize查询评价分页")
    @GetMapping("/score")
    public ResponseDTO<PageInfo<ScoreVO>> pageCurScore(@RequestParam Integer carid, @RequestParam Integer page, @RequestParam Integer pageSize){
        return null;
    }

    @ApiOperation("Hr或主管评价员工-详细评价")
    @PostMapping("/score")
    public ResponseDTO evaluate(@RequestBody ScoreAddDTO score){
        return ResponseDTO.succ();
    }

    @ApiOperation("根据carid查询该经历两项平均分")
    @GetMapping("/curavgscore/{empid}")
    public ResponseDTO<AvgScoreVO> findCurAvgScore(@RequestParam Integer empid){
        return ResponseDTO.succData(new AvgScoreVO());
    }

    @ApiOperation("录用员工")
    @PostMapping("/employ")
    public ResponseDTO employ(@RequestBody CareerAddDTO career){
        return ResponseDTO.succ();
    }

    @ApiOperation("员工离职")
    @GetMapping("/quit/{empid}")
    public ResponseDTO quit(@RequestParam Integer empid){
        return ResponseDTO.succ();
    }

    @ApiOperation("录入绩效记录")
    @PostMapping("/performance")
    public ResponseDTO performanceInput(@RequestBody PerformanceAddDTO performance){
        return ResponseDTO.succ();
    }

    @ApiOperation("录入考勤记录")
    @PostMapping("/attendance")
    public ResponseDTO attendanceInput(@RequestBody AttendanceAddDTO attendance){
        return ResponseDTO.succ();
    }

    @ApiOperation("录入违纪记录")
    @PostMapping("/crime")
    public ResponseDTO crimeInput(@RequestBody CrimeAddDTO crime){
        return ResponseDTO.succ();
    }



}
