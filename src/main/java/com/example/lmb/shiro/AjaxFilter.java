package com.example.lmb.shiro;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.lmb.pojo.vo.JsonData;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.web.filter.AccessControlFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.PrintWriter;

/**
 * @program: lmb
 * @description:
 * @author: ltx
 * @create: 2019-12-19 11:37
 **/
public class AjaxFilter extends AccessControlFilter {
    @Override
    protected boolean isAccessAllowed(ServletRequest servletRequest, ServletResponse servletResponse, Object o) throws Exception {
        Object object = SecurityUtils.getSubject().getPrincipal();
        if (object == null) return false;
        return true;
    }

    @Override
    protected boolean onAccessDenied(ServletRequest servletRequest, ServletResponse servletResponse) throws Exception {
        servletResponse.setContentType("text/json; charset=utf-8");
        PrintWriter writer = servletResponse.getWriter();
        writer.print(JSON.toJSONString(new JsonData(2,"用户未登录",null)));
        return false;
    }
}
