package com.study.mento.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.study.mento.controller")
public class WebConfig implements WebMvcConfigurer {
	
	//디스패처 서블릿이 이 파일을 읽으면서 Security 등록된 것까지 확인함
	
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.jsp("/WEB-INF/views/", ".jsp");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/dist/**")   // 요청 경로
                .addResourceLocations("/dist/"); // 실제 파일 경로  /webapp/dist/**

        registry.addResourceHandler("/assets/**")	// 요청 경로
        .addResourceLocations("/dist/assets/");		// 실제 파일 경로  /webapp/dist/assets/**
    
    }

}