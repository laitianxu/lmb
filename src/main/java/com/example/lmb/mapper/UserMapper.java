package com.example.lmb.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.lmb.pojo.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @program: lmb
 * @description:
 * @author: ltx
 * @create: 2019-12-19 10:22
 **/

@Mapper
public interface UserMapper extends BaseMapper<User> {
}
