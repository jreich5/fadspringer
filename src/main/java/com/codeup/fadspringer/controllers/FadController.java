package com.codeup.fadspringer.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FadController {

    @GetMapping("/fads")
    public String index() {
        return "fad/index";
    }

    @GetMapping("/fads/{id}")
    public String show() {
        return "fad/show";
    }

    @GetMapping("/fads/{id}/edit")
    public String edit() {
        return "fad/edit";
    }

    @PostMapping("/fads/{id}/edit")
    @ResponseBody
    public String update() {
        return "fad edit";
    }

    @GetMapping("/fads/create")
    public String create() {
        return "fad/create";
    }

    @PostMapping("/fads/create")
    @ResponseBody
    public String insert() {
        return "Insert Fad";
    }

    @PostMapping("/fads/{id}/delete")
    @ResponseBody
    public String delete() {
        return "Delete fad";
    }

}
