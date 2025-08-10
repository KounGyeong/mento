package com.study.mento.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/dbtest")
    public String dbTest(Model model) {
        String now = jdbcTemplate.queryForObject("SELECT NOW()", String.class);
        model.addAttribute("now", now);
        return "dbtest";
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }
    
    @GetMapping("/home")
    public String home() {
        return "home"; // /WEB-INF/views/home.jsp로 forward
    }
    
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    
}