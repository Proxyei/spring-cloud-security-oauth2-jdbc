package com.xywei.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author future
 * @DateTime 2019/11/15 22:19
 * @Description
 */
public class SysRole {

    private String id;
    private String roleName;
    private String role_description;

    private Set<SysUser> users = new HashSet<SysUser>();

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

    public String getRole_description() {
        return role_description;
    }

    public void setRole_description(String role_description) {
        this.role_description = role_description;
    }

    public Set<SysUser> getUsers() {
        return users;
    }

    public void setUsers(Set<SysUser> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "SysRole{" +
                "id='" + id + '\'' +
                ", roleName='" + roleName + '\'' +
                ", role_description='" + role_description + '\'' +
                ", users=" + users +
                '}';
    }
}
