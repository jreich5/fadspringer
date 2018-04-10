package com.codeup.fadspringer.controllers;

import com.codeup.fadspringer.db.User;
import com.codeup.fadspringer.db.UserSvc;
import com.codeup.fadspringer.db.Users;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
    public String edit(Model model) {
        model.addAttribute("user", usersSvc.getLoggedInUser());
        return "user/edit";
    }

    @PostMapping("/users/{id}/edit")
    public String update(HttpServletRequest request, HttpServletResponse response, @PathVariable long id, @RequestParam String name, @RequestParam String email, @RequestParam String password) {

        // not using form model binding to avoid changing password unless needed
        User originalUser = usersDao.findById(id);

        originalUser.setName(name);

        boolean emailChanged = false;

        if (!originalUser.getEmail().equals(email)) {
            originalUser.setEmail(email);
            emailChanged = true;
        }
        if (!password.equals("")) {
            originalUser.setPassword(passwordEncoder.encode(password));
        }

        usersDao.save(originalUser);

        if (emailChanged) {
            try {
                request.logout();
            } catch (ServletException e) {
                e.printStackTrace();
            }
        }

        return "redirect:/profile";

    }

    @Transactional
    @PostMapping("/users/{id}/delete")
    public String delete(@PathVariable long id, HttpServletRequest request) {
        usersDao.deleteById(id);
        try {
            request.logout();
        } catch (ServletException e) {
            e.printStackTrace();
        }
        return "redirect:/login";
    }

}
