package com.watering.domain.DTO.search;

import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: Parsley
 * @Date: 2021/04/02/18:46
 * @Description:
 */
@Data
public class SearchFilter {
    private String val;
    private Type type;

    public enum Type{
        BIRTH,GENDER,SENIORITY,DEGREE,ATTENDANCE,PERFORMANCE,ATTITUDE,ABILITY,OCCUPATION
    }

}
