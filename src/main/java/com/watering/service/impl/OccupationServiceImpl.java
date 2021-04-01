package com.watering.service.impl;

import com.watering.entity.OccupationEntity;
import com.watering.mapper.OccupationMapper;
import com.watering.service.OccupationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OccupationServiceImpl implements OccupationService {
    @Autowired
    private OccupationMapper occupationMapper;

    @Override
    public OccupationEntity find(Integer id){
        OccupationEntity entity = occupationMapper.find(id);
        return entity;
    }

    @Override
    public List<OccupationEntity> findChildren(Integer pid){
        return occupationMapper.findChildren(pid);
    }
}
