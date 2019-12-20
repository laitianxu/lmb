package com.example.lmb.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @program: lmb
 * @description:
 * @author: ltx
 * @create: 2019-12-19 10:08
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @TableId(type = IdType.AUTO)
    private Integer id;
    private String mobilePhone;
    private String pwd;
    private String regName;
    private LocalDateTime regTime;
    private Integer leaveAmount;

}
