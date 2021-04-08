package com.watering.domain.DTO.search;

import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: Parsley
 * @Date: 2021/04/02/17:07
 * @Description:
 */
@Data
public class KeyWord {
    private String val;
    private Type type;

    public enum Type{
        NAME,MAJOR,DEPARTMENT
    }

}
