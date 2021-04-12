package com.watering.controller;

import com.github.pagehelper.PageInfo;
import com.watering.domain.DTO.ResponseDTO;
import com.watering.domain.DTO.search.KeyWord;
import com.watering.domain.VO.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/career")
public class CareerController {
    @RequestMapping("/{carid}")
    public ResponseDTO<CareerVO> findCareer(@PathVariable("carid") Integer carid) {
        Integer i = carid;
        CareerVO vo = new CareerVO();
        Random random = new Random();
        vo.setId(i);
        vo.setDepartment("部门"+i);
        vo.setEnterprise("企业"+i);
        vo.setStime(new Date(110 + i, i, i));
        vo.setEtime(new Date(120 + i, i, i));
        double v = random.nextDouble() * 100;
        double v2 = random.nextDouble() * 100;
        vo.setAttendance(v);
        vo.setPerformance(v2);
        vo.setOccupation("软件工程师");
        return ResponseDTO.succData(vo);
    }

    @RequestMapping("/employee/{empid}")
    public ResponseDTO<List<CareerVO>> findEmployeeCareer(@PathVariable("empid") Integer empid){
        ArrayList<CareerVO> list = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            CareerVO vo = new CareerVO();
            vo.setId(i);
            vo.setDepartment("部门"+i);
            vo.setEnterprise("企业"+i);
            vo.setStime(new Date(110 + i, i, i));
            vo.setEtime(new Date(120 + i, i, i));
            double v = random.nextDouble() * 100;
            double v2 = random.nextDouble() * 100;
            vo.setAttendance(v);
            vo.setPerformance(v2);
            vo.setOccupation("软件工程师");
            list.add(vo);
        }
        return ResponseDTO.succData(list);
    }

    @RequestMapping("/avgscore/{empid}")
    public ResponseDTO<AvgScoreVO> searchAllAvgbyCarid(@PathVariable("empid") Integer empid){
        Random random = new Random();
        AvgScoreVO scoreVO = new AvgScoreVO(random.nextFloat() * 100, random.nextFloat() * 100);
        return ResponseDTO.succData(scoreVO);
    }

    @RequestMapping("/crime/{empid}")
    public ResponseDTO<List<CrimeVO>> searchAllCrimeByEmpid(@PathVariable("empid") Integer empid) {
        ArrayList<CrimeVO> crimes = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            CrimeVO crimeVO = new CrimeVO();
            crimeVO.setId(i);
            crimeVO.setRank(i % 5);
            crimeVO.setDetail("这个人犯罪了奥术大师多阿斯达阿斯达阿斯达阿斯达萨达萨达阿斯达阿斯达阿斯达阿斯达阿斯达阿斯达阿斯达" +
                    "奥术大师真的jaoifhaosidjv osid fioas jdfoia smdvcojaoidcvnouahsdfgoiansdcvohzoxcjv osadjfoiasjd" +
                    "zojcoiaaisdjisajdoaisjd asdjaioskdmwiamsjniochrbvoiuadnbfvoiahcviolmlzxhucvl" +
                    "asdfasweqeqqeefffcvzisufhuaijosdfjioasjilfijlfasdijlfasdijlfasdjilfasdjilfasdjilafjilsdjilfas" +
                    "djilasfdjiolasdfjiljioasdfdfgjmohjti90psdfhujildfv9o");
            crimes.add(crimeVO);
        }
        return ResponseDTO.succData(crimes);
    }

    @RequestMapping("/curavgscore/{empid}")
    public ResponseDTO<AvgScoreVO> searchThisAvgbyCarid(@PathVariable("empid") Integer empid){
        Random random = new Random();
        AvgScoreVO scoreVO = new AvgScoreVO(random.nextFloat() * 100, random.nextFloat() * 100);
        return ResponseDTO.succData(scoreVO);
    }

    @RequestMapping("/curcrime/{empid}")
    public ResponseDTO<List<CrimeVO>> searchThisCrimeByEmpid(@PathVariable("empid") Integer empid) {
        ArrayList<CrimeVO> crimes = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            CrimeVO crimeVO = new CrimeVO();
            crimeVO.setId(i);
            crimeVO.setRank(i % 5);
            crimeVO.setDetail("这个人犯罪了奥术大师多阿斯达阿斯达阿斯达阿斯达萨达萨达阿斯达阿斯达阿斯达阿斯达阿斯达阿斯达阿斯达" +
                    "奥术大师真的jaoifhaosidjv osid fioas jdfoia smdvcojaoidcvnouahsdfgoiansdcvohzoxcjv osadjfoiasjd" +
                    "zojcoiaaisdjisajdoaisjd asdjaioskdmwiamsjniochrbvoiuadnbfvoiahcviolmlzxhucvl" +
                    "asdfasweqeqqeefffcvzisufhuaijosdfjioasjilfijlfasdijlfasdijlfasdjilfasdjilfasdjilafjilsdjilfas" +
                    "djilasfdjiolasdfjiljioasdfdfgjmohjti90psdfhujildfv9o");
            crimes.add(crimeVO);
        }
        return ResponseDTO.succData(crimes);
    }

    @RequestMapping("/attendance/{carid}")
    public ResponseDTO<List<AttendanceVO>> searchAttendancebyCarId(@PathVariable("carid") Integer carid){
        ArrayList<AttendanceVO> list = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            AttendanceVO vo = new AttendanceVO();
            vo.setId(i);
            vo.setStime(new Date(110 + i, i, i));
            vo.setEtime(new Date(120 + i, i, i));
            double v = random.nextDouble() * 100;
            double v2 = random.nextDouble() * 100;
            vo.setAttendance(v);
            list.add(vo);
        }
        return ResponseDTO.succData(list);
    }

    @RequestMapping("/performance/{carid}")
    public ResponseDTO<List<PerformanceVO>> searchPerformancebyCarId(@PathVariable("carid") Integer carid){
        ArrayList<PerformanceVO> list = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            PerformanceVO vo = new PerformanceVO();
            vo.setId(i);
            vo.setStime(new Date(110 + i, i, i));
            vo.setEtime(new Date(120 + i, i, i));
            int v = random.nextInt(100);
            vo.setPerformance(v);
            list.add(vo);
        }
        return ResponseDTO.succData(list);
    }

    @RequestMapping("/score")
    public ResponseDTO<PageInfo<ScoreVO>> searchCareerScores(
            @RequestParam("carid")Integer carid,
            @RequestParam("page")Integer page,
            @RequestParam("pageSize")Integer pageSize) {
        ArrayList<ScoreVO> scores = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < pageSize; i++) {
            ScoreVO scoreVO = new ScoreVO();
            scoreVO.setDetail("我觉得海星");
            scoreVO.setIshr(i % 2 == 0);
            scoreVO.setAbility(random.nextFloat() *100);
            scoreVO.setAttitude(random.nextFloat() *100);
            scores.add(scoreVO);
        }
        PageInfo<ScoreVO> pageInfo = PageInfo.of(scores);
        pageInfo.setPageNum(page);
        pageInfo.setPageSize(pageSize);
        return ResponseDTO.succData(pageInfo);
    }
}
