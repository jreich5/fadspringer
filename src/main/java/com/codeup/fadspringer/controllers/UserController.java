package com.codeup.fadspringer.controllers;

import com.codeup.fadspringer.db.User;
import com.codeup.fadspringer.db.Users;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {


    private Users users;
    private PasswordEncoder passwordEncoder;

    public UserController(Users users, PasswordEncoder passwordEncoder) {
        this.users = users;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/register")
    public String showSignupForm(Model model){
        model.addAttribute("user", new User());
        return "auth/register";
    }

    @PostMapping("/register")
    public String saveUser(@ModelAttribute User user){
        String hash = passwordEncoder.encode(user.getPassword());
        user.setPassword(hash);
        users.save(user);
        return "redirect:/login";
    }

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
