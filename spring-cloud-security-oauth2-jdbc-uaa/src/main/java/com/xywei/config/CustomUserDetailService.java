package com.xywei.config;

import com.xywei.mapper.SysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @Author future
 * @DateTime 2019/11/15 22:46
 * @Description
 */
@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private SysUserMapper userMapper;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        User user=new User();
        return null;
    }
}
