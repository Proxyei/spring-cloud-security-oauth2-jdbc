package com.xywei.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author future
 * @DateTime 2019/11/15 22:09
 * @Description
 */
@RestController
public class TestHelloworld {

    @GetMapping("/hello")
    public String sayHello() {
        return "helloworld";
    }

    @GetMapping("/helloworld")
    public String hellowrold() {
        return "结果经过spring security认证的helloworld!";
    }

}
