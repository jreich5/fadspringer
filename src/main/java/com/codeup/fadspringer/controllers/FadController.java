package com.codeup.fadspringer.controllers;

import com.codeup.fadspringer.db.Fad;
import com.codeup.fadspringer.db.FadSvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class FadController {

    private FadSvc fadSvc;

    @Autowired
    public FadController(FadSvc fadSvc) {
        this.fadSvc = fadSvc;
    }

    @GetMapping("/fads")
    public String index(Model model) {
        model.addAttribute("fads", fadSvc.findAll());
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
    public String create(Model model) {
        model.addAttribute("fad", new Fad());
        return "fad/create";
    }

    @PostMapping("/fads/create")
    public RedirectView insert(@ModelAttribute Fad fad) {
        fadSvc.save(fad);
        return new RedirectView("/fads");
    }

    @PostMapping("/fads/{id}/delete")
    @ResponseBody
    public String delete() {
        return "Delete fad";
    }

}
