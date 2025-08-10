package com.study.mento.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public void join(String username, String password) {
    	String encPwd = encoder.encode(password);	//암호화
    	
        String sql = "INSERT INTO member(username, password) VALUES (?, ?)";
        jdbcTemplate.update(sql, username, encPwd);
    }
}
