package com.watering.dao;

import com.watering.domain.DTO.search.SearchDTO;
import com.watering.domain.entity.EmployeeEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface EmployeeEntityMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(EmployeeEntity record);

    EmployeeEntity selectByPrimaryKey(Integer id);

    List<EmployeeEntity> selectAll();

    int updateByPrimaryKey(EmployeeEntity record);

    List<EmployeeEntity> test(SearchDTO searchDTO);
}
