package com.watering.dao;

import com.watering.domain.entity.CareerEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CareerEntityMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CareerEntity record);

    CareerEntity selectByPrimaryKey(Integer id);

    List<CareerEntity> selectAll();

    int updateByPrimaryKey(CareerEntity record);
}
