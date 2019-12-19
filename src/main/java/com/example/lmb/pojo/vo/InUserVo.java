package com.example.lmb.pojo.vo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InUserVo {
    private int id;
    private String mobilePhone;
    private String pwd;
    private String regName;
}
