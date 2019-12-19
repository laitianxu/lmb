package com.example.lmb.shiro;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.lmb.mapper.UserMapper;
import com.example.lmb.pojo.User;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @program: lmb
 * @description:
 * @author: ltx
 * @create: 2019-12-19 15:05
 **/
public class MyRealm extends AuthorizingRealm {

    @Autowired
    private UserMapper userMapper;


    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("————权限认证————");
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("————身份认证方法————");
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("mobile_phone", token.getUsername());
        User user = userMapper.selectOne(wrapper);
        if (user == null) return null;
        return new SimpleAuthenticationInfo(user,user.getPwd(),getName());
    }
}
