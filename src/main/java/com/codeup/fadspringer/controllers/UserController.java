package com.codeup.fadspringer.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    @GetMapping("/users")
    public String index() {
        return "user/index";
    }

    @GetMapping("/users/{id}")
    public String show() {
        return "user/show";
    }

    @GetMapping("/users/{id}/edit")
    public String edit() {
        return "user/edit";
    }

    @PostMapping("/users/{id}/edit")
    @ResponseBody
    public String update() {
        return "Update ad";
    }

    @GetMapping("/users/{id}/delete")
    @ResponseBody
    public String delete() {
        return "User delete";
    }

}
