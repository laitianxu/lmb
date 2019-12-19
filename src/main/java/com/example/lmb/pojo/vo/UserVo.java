package com.example.lmb.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserVo {

    private long id;
    private String mobilePhone;
    private String regName;
    private LocalDateTime regTime;
    private long leaveAmount;
}
