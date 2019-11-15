package com.xywei.mapper;

import com.xywei.domain.SysUser;

/**
 * @Author future
 * @DateTime 2019/11/15 23:21
 * @Description
 */
public interface SysUserMapper {

    SysUser findUserByUsername(String username);

}
