package com.xywei.controller;

import com.xywei.common.CommonFilds;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

/**
 * @Author future
 * @DateTime 2019/11/16 18:08
 * @Description
 */
@Controller
public class UserController {

    @GetMapping("/index")
    public String index(Map<String, String> map, String access_token, String msg) {
        map.put("hello", "经过Thymeleaf模板渲染");
        if (!StringUtils.isEmpty(CommonFilds.access_token.get("access_token"))) {
            access_token = CommonFilds.access_token.get("access_token");
        }
        map.put("access_token", access_token);
        map.put("msg",msg);
        return "/index";
    }

}
