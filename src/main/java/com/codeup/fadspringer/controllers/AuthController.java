package com.codeup.fadspringer.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AuthController {

    @GetMapping("/login")
    public String loginForm() {
        return "auth/login";
    }

    @PostMapping("/login")
    @ResponseBody
    public String login() {
        return "Login";
    }

    @GetMapping("/register")
    public String registerForm() {
        return "auth/register";
    }

    @PostMapping("/register")
    @ResponseBody
    public String register() {
        return "Create user";
    }

    @PostMapping("/logout")
    @ResponseBody
    public String logout() {
        return "Logout";
    }

}
