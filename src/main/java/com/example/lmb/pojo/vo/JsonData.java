package com.example.lmb.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: lmb
 * @description:
 * @author: ltx
 * @create: 2019-12-19 15:41
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JsonData {
    private int code;
    private String msg;
    private Object data;
}
