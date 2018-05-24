package com.atp.controller;

import com.atp.config.TestProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/hello")
public class HelloController {

    @Autowired
    TestProperties testProperties;

    @RequestMapping("/home")
    public String home(){
        return "home";
    }

    @RequestMapping("/test")
    public String test(){
        StringBuilder builder = new StringBuilder();
        builder.append(testProperties.getName()+"在"+testProperties.getThing())
               .append("随机数字值是:"+testProperties.getNum())
                .append("随机大数值为："+testProperties.getBigNum())
                .append("10以下的随机数值为："+testProperties.getNum2())
                .append("10-100内的随机数值为："+testProperties.getNum3());
        return builder.toString();

    }


}
