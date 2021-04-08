package com.watering.service;

import com.watering.domain.entity.OccupationEntity;
import org.springframework.stereotype.Service;

import java.util.List;

public interface OccupationService {

    OccupationEntity find(Integer id);

    List<OccupationEntity> findChildren(Integer pid);
}
