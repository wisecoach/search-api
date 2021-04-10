package com.watering.controller;

import com.watering.domain.DTO.ResponseDTO;
import com.watering.domain.VO.AvgScoreVO;
import com.watering.domain.VO.CareerVO;
import com.watering.domain.VO.CrimeVO;
import com.watering.domain.VO.ScoreVO;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/career")
public class CareerController {
    @RequestMapping("/{empid}")
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
}
