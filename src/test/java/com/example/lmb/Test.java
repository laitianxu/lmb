package com.example.lmb;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

/**
 * @program: lmb
 * @description:
 * @author: ltx
 * @create: 2019-12-19 17:17
 **/
public class Test {
    @org.junit.jupiter.api.Test
    public void test() {
        B b = new B(12);
        System.out.println(b.age);

    }
}
