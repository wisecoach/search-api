package com.watering.security;

import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: Parsley
 * @Date: 2021/03/22/16:47
 * @Description: 权限资源获取
 */
@Component
public class MyFilterInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {

    private static HashMap<String, Collection<ConfigAttribute>> map =null;

    private void getResourcePermission(){
        map = new HashMap<>();
        //获取全部的权限
//        List<PermissionDTO> permissions = permissionService.findAllPermission();
        //遍历全部权限，把url和角色列表加入map
//        for(PermissionDTO permission : permissions){
//            map.put(permission.getUrl(),permission.getRoles());
//        }

        /*
        无数据库测试用
        ArrayList<ConfigAttribute> list = new ArrayList<>();
        list.add(new RoleDTO(1,"ROLE_admin"));
        map.put("/test**",list);
         */
    }

    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        //如果权限map不存在获取权限
        if (map == null){
            getResourcePermission();
        }
        //获取拦截的url
        HttpServletRequest request = ((FilterInvocation)object).getHttpRequest();
        Iterator<String> iterator = map.keySet().iterator();
        //遍历权限map寻找对应url所需的角色
        while(iterator.hasNext()){
            String url = iterator.next();
            if(new AntPathRequestMatcher(url).matches(request)){
                //url在权限表中返回给AccessDecisionManager的decide方法
                return map.get(url);
            }
        }
        return null;
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    //要返回true不太清楚
    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
