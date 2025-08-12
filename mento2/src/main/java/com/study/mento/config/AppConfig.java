package com.study.mento.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableScheduling
@ComponentScan(basePackages = "com.study.mento")
public class AppConfig {
    // 필요하면 추가 빈 등록 가능
}
