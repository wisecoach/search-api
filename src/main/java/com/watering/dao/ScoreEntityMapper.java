package com.watering.dao;

import com.watering.domain.entity.ScoreEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ScoreEntityMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ScoreEntity record);

    ScoreEntity selectByPrimaryKey(Integer id);

    List<ScoreEntity> selectAll();

    int updateByPrimaryKey(ScoreEntity record);

    List<ScoreEntity> listByCarid(Integer carid);

}
