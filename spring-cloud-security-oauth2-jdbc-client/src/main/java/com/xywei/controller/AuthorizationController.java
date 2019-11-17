package com.xywei.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xywei.common.CommonFilds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @Author future
 * @DateTime 2019/11/17 9:41
 * @Description
 */
@Controller
@RequestMapping("/client_a")
public class AuthorizationController {

    private static final Logger logger = LoggerFactory.getLogger(AuthorizationController.class);

    @Autowired
    private RestTemplate restTemplate;

    /**
     * @Description 请求client_a的授权，跳转到client_a登录的页面，获取code
     * @Author future
     * @DateTime 2019/11/17 9:52
     **/
    @RequestMapping("/authorization")
    public String getCode() {
        return "authorization";
    }

    /**
     * @Description 通过code获取token，跳转到访问页面
     * @Author future
     * @DateTime 2019/11/17 11:19
     **/
    @RequestMapping("/getToken")
    public String getToken(String code, Map<String, String> map) {

        //表示用过该code，应该跳转会index提示code过期，生成环境应该使用userid作为key
        if (!StringUtils.isEmpty(CommonFilds.code.get(code))) {
            map.put("msg", "expire");
            return "redirect:/index";
        }
        CommonFilds.code.put(code, code);


        if (!StringUtils.isEmpty(code)) {
            //url http://127.0.0.1:10002/uaa/oauth/token?client_id=client_a&client_secret=client_a&grant_type=authorization_code&code=code
            String url_token = "http://127.0.0.1:10002/uaa/oauth/token";
            //封装参数
            MultiValueMap<String, String> requestMap = new LinkedMultiValueMap<String, String>();
            requestMap.add("client_id", "client_a");
            requestMap.add("client_secret", "client_a");
            requestMap.add("grant_type", "authorization_code");
            //TODO code有可能过期，先判断是否过期，如果过期，直接跳转回到原来index页面
            requestMap.add("code", code);
            HttpEntity requestEntity = new HttpEntity(requestMap, null);

            //获取access_token
            String result = null;
            try {
                result = restTemplate.postForObject(url_token, requestEntity, String.class);
            } catch (RestClientException e) {
                logger.info(e.getMessage());
            }
            logger.info("请求的结果:{}", result);
            ObjectMapper objectMapper = new ObjectMapper();

            if (!StringUtils.isEmpty(result)) {
                try {
                    Map<String, Object> mapResult = objectMapper.readValue(result, Map.class);
                    String access_token = (String) mapResult.get("access_token");
                    CommonFilds.access_token.put("access_token", access_token);
                    map.put("access_token", access_token);
                } catch (JsonProcessingException e) {
                    e.printStackTrace();
                }
            }
        }


        return "index";
    }
}
