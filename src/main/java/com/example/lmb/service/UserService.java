package com.example.lmb.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.lmb.exception.NotSufficientFundsException;
import com.example.lmb.exception.PhoneExistException;
import com.example.lmb.exception.RegNameExistException;
import com.example.lmb.mapper.UserMapper;
import com.example.lmb.pojo.User;
import com.example.lmb.pojo.vo.InUserVo;
import com.example.lmb.pojo.vo.InrechargeVo;
import com.example.lmb.pojo.vo.RegVo;
import com.example.lmb.pojo.vo.UserVo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.security.auth.Subject;
import java.time.LocalDateTime;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public RegVo register(InUserVo vo) throws Exception {
        QueryWrapper<User> wrapper = new QueryWrapper<User>().eq("mobile_phone", vo.getMobilePhone());
        User user = userMapper.selectOne(wrapper);
        if (user != null) throw new PhoneExistException();
        wrapper = new QueryWrapper<User>().eq("reg_name", vo.getRegName());
        user = userMapper.selectOne(wrapper);
        if (user != null) throw new RegNameExistException();


        String pwd = new Md5Hash(vo.getPwd(), null, 1).toHex();
        user = new User(null, vo.getMobilePhone(), pwd, vo.getRegName(), LocalDateTime.now(), 0);
        userMapper.insert(user);
        return new RegVo(user.getId(),vo.getMobilePhone(),vo.getRegName());
    }

    public UserVo rechargeOrwithdraw(InrechargeVo vo,int flag) throws NotSufficientFundsException {
        User user = userMapper.selectById(vo.getMemberId());
        if (flag == 1){
            user.setLeaveAmount(user.getLeaveAmount() + vo.getAmount());
        }else {
            user.setLeaveAmount(user.getLeaveAmount() - vo.getAmount());
            if (user.getLeaveAmount() < 0) throw new NotSufficientFundsException();
        }
        userMapper.updateById(user);
        return new UserVo(user.getId(),user.getMobilePhone(),user.getRegName(),user.getRegTime(),user.getLeaveAmount());
    }


    public UserVo update(InUserVo vo) throws RegNameExistException {
        QueryWrapper<User> wrapper = new QueryWrapper<User>().eq("reg_name", vo.getRegName());
        User user = userMapper.selectOne(wrapper);
        if (user != null) throw new RegNameExistException();

        user = userMapper.selectById(vo.getId());
        user.setRegName(vo.getRegName());
        userMapper.updateById(user);
        return new UserVo(user.getId(),user.getMobilePhone(),user.getRegName(),user.getRegTime(),user.getLeaveAmount());
    }

    public UserVo getme(){
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        user = userMapper.selectById(user.getId());
        return new UserVo(user.getId(),user.getMobilePhone(),user.getRegName(),user.getRegTime(),user.getLeaveAmount());
    }


}
