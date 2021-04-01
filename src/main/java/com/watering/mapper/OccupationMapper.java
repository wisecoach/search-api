package com.watering.mapper;

import com.watering.entity.OccupationEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface OccupationMapper {
    @Select("select * from occupation where pid=#{pid}")
    List<OccupationEntity> findChildren(@Param("pid") Integer pid);

    @Select("select * from occupation where id=#{id}")
    OccupationEntity find(@Param("id") Integer id);
}
