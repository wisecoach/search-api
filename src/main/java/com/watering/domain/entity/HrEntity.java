package com.watering.domain.entity;

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
 * @Description: HR实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class HrEntity {
    private Integer id;
    private Date ctime;
    private String username;
    private String password;
    //公司id
    private Integer entid;
    private String name;
    //头像url
    private String photo;
}
