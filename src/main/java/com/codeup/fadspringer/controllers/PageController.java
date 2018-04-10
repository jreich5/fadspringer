package com.codeup.fadspringer.controllers;

import com.codeup.fadspringer.db.Fad;
import com.codeup.fadspringer.db.FadSvc;
import com.codeup.fadspringer.db.User;
import com.codeup.fadspringer.db.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PageController {

    private Users usersDao;

    @Autowired
    public PageController(Users usersDao) {
        this.usersDao = usersDao;
    }

    @GetMapping("/")
    public String welcome() {
        return "welcome";
    }

    @GetMapping("/example")
    public String example() {
        return "example/main-example";
    }

}
