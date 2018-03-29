package com.codeup.fadspringer.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FadController {

    @GetMapping("/fads")
    @ResponseBody
    public String index() {
        return "Fad index";
    }

    @GetMapping("/fads/{id}")
    @ResponseBody
    public String show() {
        return "Fad show";
    }

    @GetMapping("/fads/{id}/edit")
    @ResponseBody
    public String edit() {
        return "Edit ad";
    }

    @PostMapping("/fads/{id}/edit")
    @ResponseBody
    public String update() {
        return "Update ad";
    }

    @GetMapping("/fads/create")
    @ResponseBody
    public String create() {
        return "Fad create";
    }

    @GetMapping("/fads/{id}/delete")
    @ResponseBody
    public String delete() {
        return "Fad delete";
    }


}
