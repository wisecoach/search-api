package com.watering.dao;

import com.watering.domain.entity.DepartmentEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface DepartmentEntityMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DepartmentEntity record);

    DepartmentEntity selectByPrimaryKey(Integer id);

    List<DepartmentEntity> selectAll();

    int updateByPrimaryKey(DepartmentEntity record);
}
