package com.watering.entity.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.security.access.ConfigAttribute;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: Parsley
 * @Date: 2021/03/21/16:56
 * @Description: 角色类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RoleDTO implements ConfigAttribute {

    private Integer id;
    private String name;

    //返回角色的名称用于权限认证
    @Override
    public String getAttribute() {
        return this.name;
    }
}
