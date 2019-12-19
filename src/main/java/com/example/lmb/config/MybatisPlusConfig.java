package com.example.lmb.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: myshiro
 * @description:
 * @author: ltx
 * @create: 2019-11-08 10:03
 **/
@Configuration
@MapperScan("com.example.lmb.mapper")
public class MybatisPlusConfig {
    /**
     * 分页插件配置
     * @return
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
}
