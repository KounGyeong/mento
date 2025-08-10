package com.study.mento.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String sql = "SELECT password FROM member WHERE username = ?";
        try {
            String password = jdbcTemplate.queryForObject(sql, String.class, username);

            return User.builder()
                    .username(username)
                    .password(password)
                    .roles("USER")
                    .build();
        } catch (Exception e) {
            throw new UsernameNotFoundException("사용자를 찾을 수 없음: " + username);
        }
    }
}