package com.example.blogjpa.controller;

import com.example.blogjpa.Service.UserService;
import com.example.blogjpa.dto.AddUserRequest;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user")
    public String signup(AddUserRequest request) {
        //form-data<form action=method="post>와 같이 폼 데이터를 받을 때는 어노테이션 필요x
        //json 형태일때는 @RequestBody 써줘야함
        userService.save(request);  // 회원 가입(저장)/
        return "redirect:/login";   // 회원 가입 처리 후 로그인 페이지로 강제 이동
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        new SecurityContextLogoutHandler().logout(request, response, SecurityContextHolder.getContext().getAuthentication());
        return "redirect:/login";
    }
}