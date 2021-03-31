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
 * @Description: 公司实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EnterpriseEntity {
    private Integer id;
    private Date ctime;
    private String username;
    private String password;
    //行业id
    private Integer indid;
    private Date stime;
    private Date etime;
    //头像url
    private String photo;
}
