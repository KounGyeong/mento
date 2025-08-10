package com.study.mento.service;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class RandomCodeService {
	private JdbcTemplate jdbcTemplate;

    public RandomCodeService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void saveRandomCode(String randomString) {
        String sql = "INSERT INTO test (data_code) VALUES (?)";
        jdbcTemplate.update(sql, randomString);
    }
}
