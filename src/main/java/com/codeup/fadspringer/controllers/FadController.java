package com.codeup.fadspringer.controllers;

import com.codeup.fadspringer.db.Fad;
import com.codeup.fadspringer.db.FadSvc;

import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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
    public String show(@PathVariable Long id, Model model) {
        model.addAttribute("fad", fadSvc.findOne(id));
        return "fad/show";
    }

    @GetMapping("/fads/{id}/edit")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("fad", fadSvc.findOne(id));
        return "fad/edit";
    }

    @PostMapping("/fads/{id}/edit")
    public RedirectView update(@ModelAttribute Fad fad, @PathVariable Long id) {
        Fad oldFad = fadSvc.findOne(id);
        fad.setCreated_at(oldFad.getCreated_at());
        fad.setUser(oldFad.getUser());
        fadSvc.save(fad);
        return new RedirectView("/fads/" + id);
    }

    @GetMapping("/fads/create")
    public String create(Model model) {
        model.addAttribute("fad", new Fad());
        return "fad/create";
    }

    @PostMapping("/fads/create")
    public RedirectView insert(@ModelAttribute Fad fad) {
        String rawInput = fad.getDescription();
        String parsed = Jsoup.clean(rawInput, Whitelist.basic());
        fad.setDescription(parsed);
        fadSvc.save(fad);
        return new RedirectView("/fads");
    }

    @PostMapping("/fads/{id}/delete")
    @ResponseBody
    public String delete() {
        return "Delete fad";
    }

}
