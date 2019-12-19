package com.example.lmb.pojo;

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

    private long id;
    private String mobilePhone;
    private String pwd;
    private String regName;
    private LocalDateTime regTime;
    private long leaveAmount;

}
