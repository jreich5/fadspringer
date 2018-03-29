package com.codeup.fadspringer.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AuthController {

    @GetMapping("/login")
    @ResponseBody
    public String loginForm() {
        return "Login form";
    }

    @PostMapping("/login")
    @ResponseBody
    public String login() {
        return "Login";
    }

    @PostMapping("/logout")
    @ResponseBody
    public String logout() {
        return "Logout";
    }

}
