package com.codeup.fadspringer.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    @GetMapping("/users")
    @ResponseBody
    public String index() {
        return "User index";
    }

    @GetMapping("/users/{id}")
    @ResponseBody
    public String show() {
        return "User show";
    }

    @GetMapping("/users/{id}/edit")
    @ResponseBody
    public String edit() {
        return "Edit ad";
    }

    @PostMapping("/users/{id}/edit")
    @ResponseBody
    public String update() {
        return "Update ad";
    }

    @GetMapping("/users/create")
    @ResponseBody
    public String create() {
        return "User create";
    }

    @GetMapping("/users/{id}/delete")
    @ResponseBody
    public String delete() {
        return "User delete";
    }

}
