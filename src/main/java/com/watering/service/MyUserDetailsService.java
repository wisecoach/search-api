package com.watering.service;

import com.watering.domain.entity.HrEntity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: Parsley
 * @Date: 2021/03/22/16:39
 * @Description: 根据登录名获取UserDetails(用service获取)
 */
@Service
public class MyUserDetailsService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        List list = new ArrayList();
        list.add(new SimpleGrantedAuthority("ROLE_admin"));
        HrEntity user = new HrEntity();
        user.setName("root");
        user.setPassword(new BCryptPasswordEncoder().encode("1234"));
        user.setId(1);
        user.setAuthorities(list);
        System.out.println(user);
        return user;

    }
}
