package com.example.lmb.controller;

import com.example.lmb.exception.NotSufficientFundsException;
import com.example.lmb.exception.RegNameExistException;
import com.example.lmb.pojo.vo.*;
import com.example.lmb.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import javax.xml.ws.Action;
import javax.xml.ws.soap.Addressing;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @program: lmb
 * @description:
 * @author: ltx
 * @create: 2019-12-19 15:40
 **/
@RestController
@Api(tags = "用户模块")
public class UserController {


    @Autowired
    private UserService userService;

    @PostMapping("login")
    @ApiOperation(value="登录")
    public JsonData login(@RequestBody InUserVo inUserVo) {
        UsernamePasswordToken token = new UsernamePasswordToken(inUserVo.getMobilePhone(), inUserVo.getPwd());
        Subject subject = SecurityUtils.getSubject();
        subject.login(token);
        return new JsonData(1, "登录成功", null);
    }

    @PostMapping("register")
    @ApiOperation(value="注册")
    public JsonData register(@RequestBody InUserVo inUserVo) throws Exception {
        RegVo data = userService.register(inUserVo);
        return new JsonData(1, "OK", data);
    }

    @PostMapping("recharge")
    @ApiOperation(value="充值")
    public JsonData recharge(@RequestBody InrechargeVo vo) throws NotSufficientFundsException {
        UserVo data = userService.rechargeOrwithdraw(vo, 1);
        return new JsonData(1, "OK", data);
    }

    @PostMapping("withdraw")
    @ApiOperation(value="提现")
    public JsonData withdraw(@RequestBody InrechargeVo vo) throws NotSufficientFundsException {
        UserVo data = userService.rechargeOrwithdraw(vo, 2);
        return new JsonData(1, "OK", data);
    }

    @PostMapping("update")
    @ApiOperation(value="更新昵称")
    public JsonData update(@RequestBody InUserVo vo) throws RegNameExistException {
        UserVo data = userService.update(vo);
        return new JsonData(1, "OK", data);
    }


    @PostMapping("upload")
    @ApiOperation(value="上传文件")
    public JsonData fileUpload(@RequestParam("file") MultipartFile file) throws IOException {
//        InputStream inputStream = file.getInputStream();
//        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
//        BufferedReader buff = new BufferedReader(inputStreamReader);
        return new JsonData(1, "OK", null);
    }
}

