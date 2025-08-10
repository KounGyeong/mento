package com.study.mento.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.study.mento.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {
	
    @Autowired
    private MemberService memberService;
    
    @PostMapping("/join")
    public String join(@RequestParam String username, @RequestParam String password) {
        memberService.join(username, password);
        return "redirect:/login";
    }

    @GetMapping("/join")
    public String join() {
        return "join";
    }    
    
}
