package com.xywei.test;

import com.xywei.domain.SysUser;
import com.xywei.mapper.SysUserMapper;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @Author future
 * @DateTime 2019/11/16 0:26
 * @Description
 */
public class UserTest extends AppTestRunner {

    public static final Logger log = LoggerFactory.getLogger(UserTest.class);
    @Autowired
    private SysUserMapper userMapper;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Test
    public void testEncode() {
        String encode = passwordEncoder.encode("client_a");
        log.info("加密后密码：{}", encode);
    }

    @Test
    public void testUserMapper() {
        SysUser user = userMapper.findUserByUsername("a");
        System.out.println();
        log.info("用户信息{}", user);
    }

    @Test
    public void findUserWithRoleByUsername() {
        SysUser userWithRoleByUsername = userMapper.findUserWithRoleByUsername("a");
        log.info("查找到的用户{}", userWithRoleByUsername);
    }

    @Test
    public void testFindUserWithRoleByUsername() {
        SysUser userWithRoleBy = userMapper.findUserWithRoleByUsername("a");
        log.info("查找到的用户是:{}", userWithRoleBy);
        log.info("角色: {}", userWithRoleBy.getRoles().get(0));
    }

}
