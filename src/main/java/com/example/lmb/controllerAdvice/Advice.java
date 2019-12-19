package com.example.lmb.controllerAdvice;

import com.example.lmb.pojo.vo.JsonData;
import org.apache.shiro.authc.AuthenticationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @program: lmb
 * @description:
 * @author: ltx
 * @create: 2019-12-19 17:01
 **/
@RestControllerAdvice
public class Advice {

    @ExceptionHandler(AuthenticationException.class)
    public JsonData Authentication() {
        return new JsonData(2, "登录失败", null);
    }
}
