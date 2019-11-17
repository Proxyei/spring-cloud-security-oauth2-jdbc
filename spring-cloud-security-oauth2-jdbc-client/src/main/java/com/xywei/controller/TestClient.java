package com.xywei.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @Author future
 * @DateTime 2019/11/16 18:20
 * @Description
 */
@RestController
public class TestClient {

    @GetMapping("/hello")
    public String hello() {
        return "hello，测试通过！";
    }
}
