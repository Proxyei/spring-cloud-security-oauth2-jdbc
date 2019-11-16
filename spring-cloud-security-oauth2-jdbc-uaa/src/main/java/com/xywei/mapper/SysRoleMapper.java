package com.xywei.mapper;

import com.xywei.domain.SysRole;

import java.util.Set;

/**
 * @Author future
 * @DateTime 2019/11/15 23:22
 * @Description
 */
public interface SysRoleMapper {

   Set<SysRole> findRolesByUserName(String username);

}
