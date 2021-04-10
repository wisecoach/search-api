package com.watering.domain.VO;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: Parsley
 * @Date: 2021/04/01/19:13
 * @Description:
 */
@Data
@ApiModel(description = "平均分VO模型")
@AllArgsConstructor
@NoArgsConstructor
public class AvgScoreVO {
    //态度评分
    @ApiModelProperty("态度评分")
    private Float attitude;
    //能力评分
    @ApiModelProperty("能力评分")
    private Float ability;
}
