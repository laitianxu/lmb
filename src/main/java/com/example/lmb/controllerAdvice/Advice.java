package com.example.lmb.controllerAdvice;

import com.example.lmb.exception.NotLogInException;
import com.example.lmb.exception.NotSufficientFundsException;
import com.example.lmb.exception.PhoneExistException;
import com.example.lmb.exception.RegNameExistException;
import com.example.lmb.pojo.vo.JsonData;
import org.apache.shiro.authc.AuthenticationException;
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
    public JsonData authentication() {
        return new JsonData(2, "登录失败", null);
    }

    @ExceptionHandler(NotSufficientFundsException.class)
    public JsonData notSufficientFunds() {
        return new JsonData(2, "余额不足", null);
    }

    @ExceptionHandler(RegNameExistException.class)
    public JsonData regNameExist() {
        return new JsonData(2, "用户名已经存在", null);
    }

    @ExceptionHandler(PhoneExistException.class)
    public JsonData phoneExistException() {
        return new JsonData(2, "电话已被注册", null);
    }

    @ExceptionHandler(NotLogInException.class)
    public JsonData NotLogInException() {
        return new JsonData(2, "用户未登录", null);
    }
}
