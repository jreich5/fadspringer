package com.codeup.fadspringer.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PageController {

    @GetMapping("/")
    @ResponseBody
    public String welcome() {
        return "Welcome to FadSpringer";
    }



}
