package com.codeup.fadspringer.controllers;

import com.codeup.fadspringer.db.User;
import com.codeup.fadspringer.db.UserSvc;
import com.codeup.fadspringer.db.Users;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    private Users usersDao;
    private UserSvc usersSvc;
    private PasswordEncoder passwordEncoder;

    public UserController(Users users, PasswordEncoder passwordEncoder, UserSvc usersSvc) {
        this.usersDao = users;
        this.passwordEncoder = passwordEncoder;
        this.usersSvc = usersSvc;
    }

    @GetMapping("/register")
    public String showSignupForm(Model model){

        model.addAttribute("user", new User());
        return "auth/register";
    }

    @GetMapping("/profile")
    public String showProfileForm(Model model){
        User user = usersSvc.getLoggedInUser();
        model.addAttribute("user", user);
        return "user/profile";
    }

    @PostMapping("/register")
    public String saveUser(@ModelAttribute User user){
        String hash = passwordEncoder.encode(user.getPassword());
        user.setPassword(hash);
        usersDao.save(user);
        return "redirect:/login";
    }

    @GetMapping("/users")
    public String index(Model model) {
        model.addAttribute("users", usersDao.findAll());
        return "user/index";
    }

    @GetMapping("/users/{id}")
    public String show(@PathVariable long id, Model model) {
        model.addAttribute("user", usersDao.findById(id));
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
