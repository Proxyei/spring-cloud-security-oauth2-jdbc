package com.xywei.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author future
 * @DateTime 2019/11/15 22:19
 * @Description
 */
public class SysRole {

    private String id;
    private String roleName;
    private String roleDescription;

    private List<SysUser> users=new ArrayList<SysUser>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDescription() {
        return roleDescription;
    }

    public void setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription;
    }

    public List<SysUser> getUsers() {
        return users;
    }

    public void setUsers(List<SysUser> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "SysRole{" +
                "id='" + id + '\'' +
                ", roleName='" + roleName + '\'' +
                ", roleDescription='" + roleDescription + '\'' +
                ", users=" + users +
                '}';
    }
}

