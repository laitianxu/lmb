package com.example.lmb.controller;

import com.example.lmb.pojo.vo.JsonData;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: lmb
 * @description:
 * @author: ltx
 * @create: 2019-12-19 15:40
 **/
@RestController
public class UserController {

    @RequestMapping("/login")
    public JsonData login(String mobilePhone, String pwd) {
        UsernamePasswordToken token = new UsernamePasswordToken(mobilePhone,pwd);
        Subject subject = SecurityUtils.getSubject();
        subject.login(token);
        return new JsonData(1,"登录成功",null);
    }

}
