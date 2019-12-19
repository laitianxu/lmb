package com.example.lmb.controller;

import com.example.lmb.exception.NotSufficientFundsException;
import com.example.lmb.exception.RegNameExistException;
import com.example.lmb.pojo.vo.*;
import com.example.lmb.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.Action;
import javax.xml.ws.soap.Addressing;

/**
 * @program: lmb
 * @description:
 * @author: ltx
 * @create: 2019-12-19 15:40
 **/
@RestController
public class UserController {


    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public JsonData login(@RequestBody InUserVo inUserVo) {
        UsernamePasswordToken token = new UsernamePasswordToken(inUserVo.getMobilePhone(),inUserVo.getPwd());
        Subject subject = SecurityUtils.getSubject();
        subject.login(token);
        return new JsonData(1,"登录成功",null);
    }

    @RequestMapping("register")
    public JsonData register(@RequestBody InUserVo inUserVo) throws Exception {
        RegVo data = userService.register(inUserVo);
        return new JsonData(1,"OK",data);
    }

    @RequestMapping("recharge")
    public JsonData recharge(@RequestBody InrechargeVo vo) throws NotSufficientFundsException {
        UserVo data = userService.rechargeOrwithdraw(vo, 1);
        return new JsonData(1,"OK",data);
    }

    @RequestMapping("withdraw")
    public JsonData withdraw(@RequestBody InrechargeVo vo) throws NotSufficientFundsException {
        UserVo data = userService.rechargeOrwithdraw(vo, 2);
        return new JsonData(1,"OK",data);
    }

    @RequestMapping("update")
    public JsonData update(@RequestBody InUserVo vo) throws NotSufficientFundsException, RegNameExistException {
        UserVo data = userService.update(vo);
        return new JsonData(1,"OK",data);
    }

}
