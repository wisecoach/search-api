package com.watering.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: LKM
 * @Date: 2021/03/23/13:29
 * @Description: 职业生涯实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CareerEntity {
    private Integer id;
    private Date ctime;
    //雇员id
    private Integer empid;
    //公司id
    private Integer enpid;
    //部门id
    private Integer depid;
    private Date stime;
    private Date etime;
    //职业id
    private Integer oocid;
}
