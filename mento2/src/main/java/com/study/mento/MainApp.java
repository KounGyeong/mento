package com.study.mento;

import org.springframework.context.support.ClassPathXmlApplicationContext;


public class MainApp {
	public static void main(String[] args) throws Exception {
        new ClassPathXmlApplicationContext("applicationContext.xml");
    }
}
