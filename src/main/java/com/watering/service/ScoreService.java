package com.watering.service;

import com.github.pagehelper.PageInfo;
import com.watering.domain.DTO.ResponseDTO;
import com.watering.domain.DTO.score.ScoreAddDTO;
import com.watering.domain.VO.ScoreVO;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: Parsley
 * @Date: 2021/04/10/20:18
 * @Description:
 */
public interface ScoreService {

    public ResponseDTO evaluate(ScoreAddDTO scoreAddDTO);

    public ResponseDTO<PageInfo<ScoreVO>> pageCurScore(Integer carid,Integer page,Integer pageSize);

}
