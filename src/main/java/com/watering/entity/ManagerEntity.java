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
 * @Description: 主管实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ManagerEntity {
    private Integer id;
    private Date ctime;
    private String username;
    private String password;
    //公司id
    private Integer entid;
    //部门id
    private Integer depid;
    private String name;
    //头像 url
    private String photo;
}
