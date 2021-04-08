package com.watering.mapper;

import com.watering.domain.entity.EmployeeEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface EmployeeMapper {
    @Select("select * from employee where id = #{id}")
    EmployeeEntity find(@Param("id") Integer id);

    @Select("select * from employee limit 5")
    List<EmployeeEntity> findList();
}
