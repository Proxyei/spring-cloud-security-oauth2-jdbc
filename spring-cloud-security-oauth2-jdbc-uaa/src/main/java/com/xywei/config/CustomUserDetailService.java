package com.xywei.config;

import com.xywei.domain.SysUser;
import com.xywei.mapper.SysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

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

        SysUser user = userMapper.findUserWithRoleByUsername(username);
        Set<GrantedAuthority> authorities = new HashSet<>();
        user.getRoles().forEach(r -> {
            StringBuffer role = new StringBuffer("ROLE_");
            role.append(r.getRoleName());
            SimpleGrantedAuthority authority = new SimpleGrantedAuthority(role.toString());
            authorities.add(authority);

        });

        User userDetail = new User(user.getUsername(), user.getPassword(), authorities);
        return userDetail;
    }
}
