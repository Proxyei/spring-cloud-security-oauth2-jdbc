package com.xywei.test;

import com.xywei.domain.SysUser;
import com.xywei.mapper.SysUserMapper;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author future
 * @DateTime 2019/11/16 0:26
 * @Description
 */
public class UserTest extends AppTestRunner {

    public static final Logger log = LoggerFactory.getLogger(UserTest.class);
    @Autowired
    private SysUserMapper userMapper;

    @Test
    public void testUserMapper() {
        SysUser user = userMapper.findUserByUsername("a");
        System.out.println();
        log.info("用户信息{}", user);
    }

}
