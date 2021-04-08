package com.watering.controller;

import com.github.pagehelper.PageInfo;
import com.watering.domain.DTO.ResponseDTO;
import com.watering.domain.DTO.search.KeyWord;
import com.watering.domain.DTO.search.SearchDTO;
import com.watering.domain.VO.EmployeeVO;
import com.watering.domain.VO.HrVO;
import com.watering.domain.entity.DepartmentEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

@RestController
@RequestMapping("/search")
public class SearchController {
    private static int page = 0;
    @RequestMapping("department")
    public ResponseDTO searchAllDepartment(){
        ArrayList<DepartmentEntity> entities = new ArrayList<>();
        entities.add(new DepartmentEntity(1, new Date(), "人事部", 1));
        entities.add(new DepartmentEntity(2, new Date(), "研发部", 1));
        entities.add(new DepartmentEntity(3, new Date(), "公关部", 1));
        entities.add(new DepartmentEntity(4, new Date(), "市场部", 1));
        return ResponseDTO.succData(entities);
    }

    @RequestMapping("inner")
    public ResponseDTO searchInnerEmployee(
            @RequestBody SearchDTO searchDTO
        ) {
        Integer page = searchDTO.getPage();
        // Integer page = SearchController.page ++;
        Integer pageSize = searchDTO.getPageSize();
        KeyWord.Type type = searchDTO.getKey().getType();
        String val = searchDTO.getKey().getValue();
        // Integer pageSize = 20;
        ArrayList<EmployeeVO> employees = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < pageSize; i++) {
            String tel = new Integer(random.nextInt(100) + 100).toString() +
                    new Integer(random.nextInt(9000) + 1000).toString() +
                    new Integer(random.nextInt(9000) + 1000).toString();
            String address = "你猜我家在哪";
            String mail = tel + "@qq.com";
            String enterprise = "果蔬文化有限公司";
            String department = "技术部";
            String innid = new Integer(i).toString();
            EmployeeVO employeeVO = new EmployeeVO(tel, true, "", address, mail, "", enterprise, department, new HrVO(), innid);
            employeeVO.setId(i);
            employeeVO.setName(type + ":" + val + innid + "page" + page);
            employeeVO.setBirth(new Date());
            employeeVO.setGender(i%2);
            employeeVO.setDegree(i%7 + 1);
            employees.add(employeeVO);
        }
        PageInfo<EmployeeVO> pageInfo = PageInfo.of(employees);
        pageInfo.setPageNum(page);
        pageInfo.setPageSize(pageSize);
        return ResponseDTO.succData(pageInfo);
    }
}
