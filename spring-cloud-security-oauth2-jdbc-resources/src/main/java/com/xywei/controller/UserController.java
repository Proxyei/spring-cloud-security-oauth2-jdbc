package com.xywei.controller;

import org.springframework.web.bind.annotation.*;

/**
 * @Author future
 * @DateTime 2019/11/16 14:38
 * @Description
 */
@RestController
public class UserController {

    @GetMapping("/user")
    public String userList() {
        return "查询用户：{name: client_a}";
    }

    @DeleteMapping("/user")
    public String deleteUser() {
        return "删除用户成功";
    }

    @PostMapping("/user")
    public String addUser() {
        return "添加用户成功";
    }

    @PutMapping("/user")
    public String updateUser() {
        return "更新用户成功";
    }


}
