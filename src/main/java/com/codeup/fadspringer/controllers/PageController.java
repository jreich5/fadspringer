package com.codeup.fadspringer.controllers;

import com.codeup.fadspringer.db.Fad;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PageController {

    @GetMapping("/")
    public String welcome() {
        return "welcome";
    }

    @GetMapping("/example")
    public String example() {
        return "example/main-example";
    }

}
